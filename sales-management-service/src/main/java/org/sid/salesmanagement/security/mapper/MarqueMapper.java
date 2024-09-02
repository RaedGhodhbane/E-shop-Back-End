package org.sid.salesmanagement.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.salesmanagement.entities.Article;
import org.sid.salesmanagement.entities.Marque;
import org.sid.salesmanagement.security.dto.MarqueDTO;

@Mapper
public interface MarqueMapper {
    MarqueMapper INSTANCE = Mappers.getMapper(MarqueMapper.class);

    MarqueDTO marqueToMarqueDTO(Marque marque);

    Marque marqueDTOToMarque(MarqueDTO marqueDTO);
}
