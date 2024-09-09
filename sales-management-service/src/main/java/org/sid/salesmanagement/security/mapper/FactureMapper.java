package org.sid.salesmanagement.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.salesmanagement.entities.Facture;
import org.sid.salesmanagement.security.dto.FactureDTO;

@Mapper
public interface FactureMapper {
    FactureMapper INSTANCE = Mappers.getMapper(FactureMapper.class);

    FactureDTO factureToFactureDTO(Facture facture);

    Facture factureDTOToFacture(FactureDTO factureDTO);
}
