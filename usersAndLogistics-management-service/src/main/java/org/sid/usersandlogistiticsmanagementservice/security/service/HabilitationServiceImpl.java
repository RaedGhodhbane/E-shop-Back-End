package org.sid.usersandlogistiticsmanagementservice.security.service;

import org.sid.usersandlogistiticsmanagementservice.entities.Habilitation;
import org.sid.usersandlogistiticsmanagementservice.repository.HabilitationRepository;
import org.sid.usersandlogistiticsmanagementservice.security.dto.HabilitationDTO;
import org.sid.usersandlogistiticsmanagementservice.security.mapper.HabilitationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilitationServiceImpl implements HabilitationService {
    @Autowired
    private HabilitationRepository habilitationRepository;
    @Autowired
    private HabilitationMapper habilitationMapper;

    public HabilitationDTO createHabilitation(HabilitationDTO habilitationDTO) {
        Habilitation habilitation = habilitationMapper.habilitationDTOToHabilitation(habilitationDTO);
        Habilitation savedHabilitation = habilitationRepository.save(habilitation);
        return habilitationMapper.habilitationToHabilitationDTO(savedHabilitation);
    }

    public HabilitationDTO getHabilitationById(Integer id) {
        Habilitation habilitation = habilitationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Habilitation not found"));
        return habilitationMapper.habilitationToHabilitationDTO(habilitation);
    }

    public List<HabilitationDTO> getAllHabilitations() {
        return habilitationRepository.findAll().stream()
                .map(habilitationMapper::habilitationToHabilitationDTO)
                .toList();
    }

    public HabilitationDTO updateHabilitation(Integer id, HabilitationDTO habilitationDTO) {
        Habilitation existingHabilitation = habilitationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Habilitation not found"));
        Habilitation updatedHabilitation = habilitationMapper.habilitationDTOToHabilitation(habilitationDTO);
        updatedHabilitation.setId(id);
        updatedHabilitation = habilitationRepository.save(updatedHabilitation);
        return habilitationMapper.habilitationToHabilitationDTO(updatedHabilitation);
    }

    public void deleteHabilitation(Integer id) {
        Habilitation habilitation = habilitationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Habilitation not found"));
        habilitationRepository.delete(habilitation);
    }
}
