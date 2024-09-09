package org.sid.salesmanagement.security.service;

import org.sid.salesmanagement.entities.Facture;
import org.sid.salesmanagement.repository.FactureRepository;
import org.sid.salesmanagement.security.dto.FactureDTO;
import org.sid.salesmanagement.security.mapper.FactureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureService {
    @Autowired
    private FactureRepository factureRepository;
    @Autowired
    private FactureMapper factureMapper;

    public FactureDTO createFacture(FactureDTO factureDTO) {
        Facture facture = factureMapper.factureDTOToFacture(factureDTO);
        Facture savedFacture = factureRepository.save(facture);
        return factureMapper.factureToFactureDTO(savedFacture);
    }

    public FactureDTO getFactureById(Long id) {
        Facture facture = factureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Facture not found"));
        return factureMapper.factureToFactureDTO(facture);
    }

    public List<FactureDTO> getAllFactures() {
        return factureRepository.findAll().stream()
                .map(factureMapper::factureToFactureDTO)
                .toList();
    }

    public FactureDTO updateFacture(Long id, FactureDTO factureDTO) {
        Facture existingFacture = factureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Facture not found"));
        Facture updatedFacture = factureMapper.factureDTOToFacture(factureDTO);
        updatedFacture.setId(id);
        updatedFacture = factureRepository.save(updatedFacture);
        return factureMapper.factureToFactureDTO(updatedFacture);
    }

    public void deleteFacture(Long id) {
        Facture facture = factureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Facture not found"));
        factureRepository.delete(facture);
    }
}
