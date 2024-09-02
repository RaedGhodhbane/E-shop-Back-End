package org.sid.salesmanagement.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.salesmanagement.entities.Categorie;
import org.sid.salesmanagement.security.dto.CategorieDTO;

@Mapper
public interface CategorieMapper {
    CategorieMapper INSTANCE = Mappers.getMapper(CategorieMapper.class);
    CategorieDTO categorieToCategorieDTO(Categorie categorie);

    Categorie categorieDTOToCategorie(CategorieDTO categorieDTO);
}
