package org.sid.usersandlogistiticsmanagementservice.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.usersandlogistiticsmanagementservice.entities.ModeLivraison;
import org.sid.usersandlogistiticsmanagementservice.security.dto.ModeLivraisonDTO;

@Mapper
public interface ModeLivraisonMapper {
    ModeLivraisonMapper INSTANCE = Mappers.getMapper(ModeLivraisonMapper.class);

    ModeLivraisonDTO modeLivraisonToModeLivraisonDTO(ModeLivraison modeLivraison);

    ModeLivraison modeLivraisonDTOToModeLivraison(ModeLivraisonDTO modeLivraisonDTO);
}
