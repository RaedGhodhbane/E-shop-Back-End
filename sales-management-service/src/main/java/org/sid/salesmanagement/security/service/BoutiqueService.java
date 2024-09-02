package org.sid.salesmanagement.security.service;

import org.sid.salesmanagement.entities.Boutique;
import org.sid.salesmanagement.repository.BoutiqueRepository;
import org.sid.salesmanagement.security.dto.BoutiqueDTO;
import org.sid.salesmanagement.security.mapper.BoutiqueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoutiqueService {
    @Autowired
    private BoutiqueRepository boutiqueRepository;
    @Autowired
    private BoutiqueMapper boutiqueMapper;

    public BoutiqueDTO createBoutique(BoutiqueDTO boutiqueDTO) {
        Boutique boutique = boutiqueMapper.boutiqueDTOToBoutique(boutiqueDTO);
        Boutique savedBoutique = boutiqueRepository.save(boutique);
        return boutiqueMapper.boutiqueToBoutiqueDTO(savedBoutique);
    }

    public BoutiqueDTO getBoutiqueById(Long id) {
        Boutique boutique = boutiqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Boutique not found"));
        return boutiqueMapper.boutiqueToBoutiqueDTO(boutique);
    }

    public List<BoutiqueDTO> getAllBoutiques() {
        return boutiqueRepository.findAll().stream()
                .map(boutiqueMapper::boutiqueToBoutiqueDTO)
                .collect(Collectors.toList());
    }

    public BoutiqueDTO updateBoutique(Long id, BoutiqueDTO boutiqueDTO) {
        Boutique existingBoutique = boutiqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Boutique not found"));
        Boutique updatedBoutique = boutiqueMapper.boutiqueDTOToBoutique(boutiqueDTO);
        updatedBoutique.setId(id);
        updatedBoutique = boutiqueRepository.save(updatedBoutique);
        return boutiqueMapper.boutiqueToBoutiqueDTO(updatedBoutique);
    }

    public void deleteBoutique(Long id) {
        Boutique boutique = boutiqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Boutique not found"));
        boutiqueRepository.delete(boutique);
    }
}
