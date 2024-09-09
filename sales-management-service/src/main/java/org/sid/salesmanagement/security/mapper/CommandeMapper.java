package org.sid.salesmanagement.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.salesmanagement.entities.Commande;
import org.sid.salesmanagement.security.dto.CommandeDTO;

@Mapper
public interface CommandeMapper {
    CommandeMapper INSTANCE = Mappers.getMapper(CommandeMapper.class);
    CommandeDTO commandeToCommandeDTO(Commande commande);

    Commande commandeDTOToCommande(CommandeDTO commandeDTO);
}
