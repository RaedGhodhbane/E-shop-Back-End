package org.sid.usersandlogistiticsmanagementservice.security.service;

import org.sid.usersandlogistiticsmanagementservice.security.dto.LivraisonDTO;
import org.sid.usersandlogistiticsmanagementservice.security.dto.ModeLivraisonDTO;

import java.util.List;

public interface ModeLivraisonService {
    ModeLivraisonDTO createModeLivraison(ModeLivraisonDTO modeLivraisonDTO);

    ModeLivraisonDTO getModeLivraisonById(Long id);

    List<ModeLivraisonDTO> getAllModeLivraisons();

    ModeLivraisonDTO updateModeLivraison(Long id, ModeLivraisonDTO modelivraisonDTO);

    void deleteModeLivraison(Long id);
}
