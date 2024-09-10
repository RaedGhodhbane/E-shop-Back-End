package org.sid.usersandlogistiticsmanagementservice.security.service;

import org.sid.usersandlogistiticsmanagementservice.security.dto.UtilisateurDTO;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO);

    UtilisateurDTO getUtilisateurById(Integer id);

    List<UtilisateurDTO> getAllUtilisateurs();

    UtilisateurDTO updateUtilisateur(Integer id, UtilisateurDTO utilisateurDTO);

    void deleteUtilisateur(Integer id);
}
