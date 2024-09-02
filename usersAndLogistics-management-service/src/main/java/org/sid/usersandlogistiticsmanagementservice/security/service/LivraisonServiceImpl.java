package org.sid.usersandlogistiticsmanagementservice.security.service;

import org.sid.usersandlogistiticsmanagementservice.entities.Livraison;
import org.sid.usersandlogistiticsmanagementservice.repository.LivraisonRepository;
import org.sid.usersandlogistiticsmanagementservice.security.dto.LivraisonDTO;
import org.sid.usersandlogistiticsmanagementservice.security.mapper.LivraisonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivraisonServiceImpl implements LivraisonService {

    @Autowired
    private LivraisonRepository livraisonRepository;

    @Autowired
    private LivraisonMapper livraisonMapper; // Injection du mapper

    public LivraisonDTO createLivraison(LivraisonDTO livraisonDTO) {
        Livraison livraison = livraisonMapper.livraisonDTOToLivraison(livraisonDTO);
        Livraison savedLivraison = livraisonRepository.save(livraison);
        return livraisonMapper.livraisonToLivraisonDTO(savedLivraison);
    }

    public LivraisonDTO getLivraisonById(Long id) {
        Livraison livraison = livraisonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livraison not found"));
        return livraisonMapper.livraisonToLivraisonDTO(livraison);
    }

    public List<LivraisonDTO> getAllLivraisons() {
        return livraisonRepository.findAll().stream()
                .map(livraisonMapper::livraisonToLivraisonDTO)
                .toList();
    }

    public LivraisonDTO updateLivraison(Long id, LivraisonDTO livraisonDTO) {
        Livraison existingLivraison = livraisonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livraison not found"));
        Livraison updatedLivraison = livraisonMapper.livraisonDTOToLivraison(livraisonDTO);
        updatedLivraison.setId(id);
        updatedLivraison = livraisonRepository.save(updatedLivraison);
        return livraisonMapper.livraisonToLivraisonDTO(updatedLivraison);
    }

    public void deleteLivraison(Long id) {
        Livraison livraison = livraisonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livraison not found"));
        livraisonRepository.delete(livraison);
    }
}
