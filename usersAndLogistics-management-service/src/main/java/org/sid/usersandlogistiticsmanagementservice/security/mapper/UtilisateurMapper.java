package org.sid.usersandlogistiticsmanagementservice.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.usersandlogistiticsmanagementservice.entities.Utilisateur;
import org.sid.usersandlogistiticsmanagementservice.security.dto.UtilisateurDTO;

@Mapper
public interface UtilisateurMapper {
    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

    UtilisateurDTO utilisateurToUtilisateurDTO(Utilisateur utilisateur);

    Utilisateur utilisateurDTOToUtilisateur(UtilisateurDTO utilisateurDTO);
}
