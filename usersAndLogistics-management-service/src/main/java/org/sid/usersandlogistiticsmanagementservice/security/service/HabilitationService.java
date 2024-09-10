package org.sid.usersandlogistiticsmanagementservice.security.service;

import org.sid.usersandlogistiticsmanagementservice.security.dto.HabilitationDTO;

import java.util.List;

public interface HabilitationService {
    HabilitationDTO createHabilitation(HabilitationDTO habilitationDTO);

    HabilitationDTO getHabilitationById(Integer id);

    List<HabilitationDTO> getAllHabilitations();

    HabilitationDTO updateHabilitation(Integer id, HabilitationDTO habilitationDTO);

    void deleteHabilitation(Integer id);
}
