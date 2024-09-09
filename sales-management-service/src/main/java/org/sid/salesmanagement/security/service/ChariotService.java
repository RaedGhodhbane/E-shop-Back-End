package org.sid.salesmanagement.security.service;

import org.sid.salesmanagement.entities.Chariot;
import org.sid.salesmanagement.repository.ChariotRepository;
import org.sid.salesmanagement.security.dto.ChariotDTO;
import org.sid.salesmanagement.security.mapper.ChariotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChariotService {
    @Autowired
    private ChariotRepository chariotRepository;

    @Autowired
    private ChariotMapper chariotMapper;

    public ChariotDTO createChariot(ChariotDTO chariotDTO) {
        Chariot chariot = chariotMapper.chariotDTOToChariot(chariotDTO);
        Chariot savedChariot = chariotRepository.save(chariot);
        return chariotMapper.chariotToChariotDTO(savedChariot);
    }

    public ChariotDTO getChariotById(Long id) {
        Chariot chariot = chariotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Chariot not found"));
        return chariotMapper.chariotToChariotDTO(chariot);
    }

    public List<ChariotDTO> getAllChariots() {
        return chariotRepository.findAll().stream()
                .map(chariotMapper::chariotToChariotDTO)
                .toList();
    }

    public ChariotDTO updateChariot(Long id, ChariotDTO chariotDTO) {
        Chariot existingChariot = chariotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Chariot not found"));
        Chariot updatedChariot = chariotMapper.chariotDTOToChariot(chariotDTO);
        updatedChariot.setId(id);
        updatedChariot = chariotRepository.save(updatedChariot);
        return chariotMapper.chariotToChariotDTO(updatedChariot);
    }

    public void deleteChariot(Long id) {
        Chariot chariot = chariotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Chariot not found"));
        chariotRepository.delete(chariot);
    }
}
