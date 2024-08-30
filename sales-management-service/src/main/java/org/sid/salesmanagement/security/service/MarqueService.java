package org.sid.salesmanagement.security.service;

import org.sid.salesmanagement.entities.Marque;
import org.sid.salesmanagement.repository.MarqueRepository;
import org.sid.salesmanagement.security.dto.MarqueDTO;
import org.sid.salesmanagement.security.mapper.MarqueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarqueService {

    @Autowired
    private MarqueRepository marqueRepository;

    @Autowired
    private MarqueMapper marqueMapper; // Injection du mapper

    // Créer une nouvelle marque
    public MarqueDTO createMarque(MarqueDTO marqueDTO) {
        Marque marque = marqueMapper.marqueDTOToMarque(marqueDTO);
        Marque savedMarque = marqueRepository.save(marque);
        return marqueMapper.marqueToMarqueDTO(savedMarque);
    }

    // Obtenir une marque par son ID
    public MarqueDTO getMarqueById(Long id) {
        Marque marque = marqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Marque not found"));
        return marqueMapper.marqueToMarqueDTO(marque);
    }

    // Obtenir toutes les marques
    public List<MarqueDTO> getAllMarques() {
        return marqueRepository.findAll().stream()
                .map(marqueMapper::marqueToMarqueDTO)
                .collect(Collectors.toList());
    }

    // Mettre à jour une marque existante
    public MarqueDTO updateMarque(Long id, MarqueDTO marqueDTO) {
        Marque existingMarque = marqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Marque not found"));
        Marque updatedMarque = marqueMapper.marqueDTOToMarque(marqueDTO);
        updatedMarque.setId(id); // Conserver l'ID pour la mise à jour
        updatedMarque = marqueRepository.save(updatedMarque);
        return marqueMapper.marqueToMarqueDTO(updatedMarque);
    }

    // Supprimer une marque
    public void deleteMarque(Long id) {
        Marque marque = marqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Marque not found"));
        marqueRepository.delete(marque);
    }
}
