package org.sid.salesmanagement.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.salesmanagement.entities.EtatCmd;
import org.sid.salesmanagement.security.dto.EtatCmdDTO;

@Mapper
public interface EtatCmdMapper {
    EtatCmdMapper INSTANCE = Mappers.getMapper(EtatCmdMapper.class);

    EtatCmdDTO etatCmdToEtatCmdDTO(EtatCmd etatcmd);

    EtatCmd etatCmdDTOToEtatCmd(EtatCmdDTO etatcmdDTO);
}
