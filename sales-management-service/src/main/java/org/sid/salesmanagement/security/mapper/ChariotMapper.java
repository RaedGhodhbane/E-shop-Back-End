package org.sid.salesmanagement.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.salesmanagement.entities.Chariot;
import org.sid.salesmanagement.security.dto.ChariotDTO;

@Mapper
public interface ChariotMapper {
    ChariotMapper INSTANCE = Mappers.getMapper(ChariotMapper.class);

    ChariotDTO chariotToChariotDTO(Chariot chariot);

    Chariot chariotDTOToChariot(ChariotDTO chariotDTO);
}
