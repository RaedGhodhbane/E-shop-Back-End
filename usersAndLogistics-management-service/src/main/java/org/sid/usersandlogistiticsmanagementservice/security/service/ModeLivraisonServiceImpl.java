package org.sid.usersandlogistiticsmanagementservice.security.service;

import org.sid.usersandlogistiticsmanagementservice.entities.ModeLivraison;
import org.sid.usersandlogistiticsmanagementservice.repository.ModeLivraisonRepository;
import org.sid.usersandlogistiticsmanagementservice.security.dto.ModeLivraisonDTO;
import org.sid.usersandlogistiticsmanagementservice.security.mapper.ModeLivraisonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeLivraisonServiceImpl implements ModeLivraisonService {
    @Autowired
    private ModeLivraisonRepository modeLivraisonRepository;

    @Autowired
    private ModeLivraisonMapper modeLivraisonMapper; // Injection du mapper

    public ModeLivraisonDTO createModeLivraison(ModeLivraisonDTO modeLivraisonDTO) {
        ModeLivraison modeLivraison = modeLivraisonMapper.modeLivraisonDTOToModeLivraison(modeLivraisonDTO);
        ModeLivraison savedModeLivraison = modeLivraisonRepository.save(modeLivraison);
        return modeLivraisonMapper.modeLivraisonToModeLivraisonDTO(savedModeLivraison);
    }

    public ModeLivraisonDTO getModeLivraisonById(Long id) {
        ModeLivraison modeLivraison = modeLivraisonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ModeLivraison not found"));
        return modeLivraisonMapper.modeLivraisonToModeLivraisonDTO(modeLivraison);
    }

    public List<ModeLivraisonDTO> getAllModeLivraisons() {
        return modeLivraisonRepository.findAll().stream()
                .map(modeLivraisonMapper::modeLivraisonToModeLivraisonDTO)
                .toList();
    }

    public ModeLivraisonDTO updateModeLivraison(Long id,ModeLivraisonDTO modeLivraisonDTO) {
        ModeLivraison existingModeLivraison = modeLivraisonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ModeLivraison not found"));
        ModeLivraison updatedModeLivraison = modeLivraisonMapper.modeLivraisonDTOToModeLivraison(modeLivraisonDTO);
        updatedModeLivraison.setId(id);
        updatedModeLivraison = modeLivraisonRepository.save(updatedModeLivraison);
        return modeLivraisonMapper.modeLivraisonToModeLivraisonDTO(updatedModeLivraison);
    }

    public void deleteModeLivraison(Long id) {
        ModeLivraison modeLivraison = modeLivraisonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ModeLivraison not found"));
        modeLivraisonRepository.delete(modeLivraison);
    }
}
