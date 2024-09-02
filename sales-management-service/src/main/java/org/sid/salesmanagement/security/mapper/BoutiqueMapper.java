package org.sid.salesmanagement.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.salesmanagement.entities.Boutique;
import org.sid.salesmanagement.security.dto.BoutiqueDTO;

@Mapper
public interface BoutiqueMapper {

    BoutiqueMapper INSTANCE = Mappers.getMapper(BoutiqueMapper.class);

    BoutiqueDTO boutiqueToBoutiqueDTO(Boutique boutique);

    Boutique boutiqueDTOToBoutique(BoutiqueDTO boutiqueDTO);
}
