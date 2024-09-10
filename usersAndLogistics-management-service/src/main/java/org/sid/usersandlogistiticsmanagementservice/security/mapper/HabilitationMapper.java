package org.sid.usersandlogistiticsmanagementservice.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.usersandlogistiticsmanagementservice.entities.Habilitation;
import org.sid.usersandlogistiticsmanagementservice.security.dto.HabilitationDTO;

@Mapper
public interface HabilitationMapper {
    HabilitationMapper INSTANCE = Mappers.getMapper(HabilitationMapper.class);

    HabilitationDTO habilitationToHabilitationDTO(Habilitation habilitation);

    Habilitation habilitationDTOToHabilitation(HabilitationDTO habilitationDTO);
}
