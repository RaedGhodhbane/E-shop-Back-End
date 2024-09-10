package org.sid.usersandlogistiticsmanagementservice.security.service;

import jdk.jshell.execution.Util;
import org.sid.usersandlogistiticsmanagementservice.entities.Utilisateur;
import org.sid.usersandlogistiticsmanagementservice.repository.UtilisateurRepository;
import org.sid.usersandlogistiticsmanagementservice.security.dto.UtilisateurDTO;
import org.sid.usersandlogistiticsmanagementservice.security.mapper.UtilisateurMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private UtilisateurMapper utilisateurMapper;

    public UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurMapper.utilisateurDTOToUtilisateur(utilisateurDTO);
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.utilisateurToUtilisateurDTO(savedUtilisateur);
    }

    public UtilisateurDTO getUtilisateurById(Integer id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found"));
        return utilisateurMapper.utilisateurToUtilisateurDTO(utilisateur);
    }

    public List<UtilisateurDTO> getAllUtilisateurs() {
        return utilisateurRepository.findAll().stream()
                .map(utilisateurMapper::utilisateurToUtilisateurDTO)
                .toList();
    }

    public UtilisateurDTO updateUtilisateur(Integer id,UtilisateurDTO utilisateurDTO) {
        Utilisateur existingUtilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found"));
        Utilisateur updatedUtilisateur = utilisateurMapper.utilisateurDTOToUtilisateur(utilisateurDTO);
        updatedUtilisateur.setId(id);
        updatedUtilisateur = utilisateurRepository.save(updatedUtilisateur);
        return utilisateurMapper.utilisateurToUtilisateurDTO(updatedUtilisateur);
    }

    public void deleteUtilisateur(Integer id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found"));
        utilisateurRepository.delete(utilisateur);
    }
}
