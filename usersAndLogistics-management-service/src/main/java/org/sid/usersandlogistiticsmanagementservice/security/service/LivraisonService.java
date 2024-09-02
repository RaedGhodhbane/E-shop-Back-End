package org.sid.usersandlogistiticsmanagementservice.security.service;

import org.sid.usersandlogistiticsmanagementservice.security.dto.LivraisonDTO;

import java.util.List;

public interface LivraisonService {
    LivraisonDTO createLivraison(LivraisonDTO livraisonDTO);

    LivraisonDTO getLivraisonById(Long id);

    List<LivraisonDTO> getAllLivraisons();

    LivraisonDTO updateLivraison(Long id, LivraisonDTO livraisonDTO);

    void deleteLivraison(Long id);
}
