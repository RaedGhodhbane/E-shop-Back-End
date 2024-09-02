package org.sid.usersandlogistiticsmanagementservice.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.usersandlogistiticsmanagementservice.entities.Livraison;
import org.sid.usersandlogistiticsmanagementservice.security.dto.LivraisonDTO;

import java.util.List;

@Mapper
public interface LivraisonMapper {
    LivraisonMapper INSTANCE = Mappers.getMapper(LivraisonMapper.class);

    LivraisonDTO livraisonToLivraisonDTO(Livraison livraison);

    Livraison livraisonDTOToLivraison(LivraisonDTO livraisonDTO);

}
