package org.sid.usersandlogistiticsmanagementservice.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.usersandlogistiticsmanagementservice.entities.Adresse;
import org.sid.usersandlogistiticsmanagementservice.security.dto.AdresseDTO;

@Mapper
public interface AdresseMapper {
    AdresseMapper INSTANCE = Mappers.getMapper(AdresseMapper.class);

    AdresseDTO adresseToAdresseDTO(Adresse adresse);

    Adresse adresseDTOToAdresse(AdresseDTO adresseDTO);
}
