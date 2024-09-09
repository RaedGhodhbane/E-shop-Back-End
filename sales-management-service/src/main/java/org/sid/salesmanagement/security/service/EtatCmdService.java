package org.sid.salesmanagement.security.service;

import org.sid.salesmanagement.entities.EtatCmd;
import org.sid.salesmanagement.repository.EtatCmdRepository;
import org.sid.salesmanagement.security.dto.EtatCmdDTO;
import org.sid.salesmanagement.security.mapper.EtatCmdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtatCmdService {
    @Autowired
    private EtatCmdRepository etatCmdRepository;
    @Autowired
    private EtatCmdMapper etatCmdMapper;

    public EtatCmdDTO createEtatCmd(EtatCmdDTO etatCmdDTO) {
        EtatCmd etatCmd = etatCmdMapper.etatCmdDTOToEtatCmd(etatCmdDTO);
        EtatCmd savedEtatCmd = etatCmdRepository.save(etatCmd);
        return etatCmdMapper.etatCmdToEtatCmdDTO(savedEtatCmd);
    }

    public EtatCmdDTO getEtatCmdById(Long id) {
        EtatCmd etatCmd = etatCmdRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("EtatCmd not found"));
        return etatCmdMapper.etatCmdToEtatCmdDTO(etatCmd);
    }

    public List<EtatCmdDTO> getAllEtatsCmds() {
        return etatCmdRepository.findAll().stream()
                .map(etatCmdMapper::etatCmdToEtatCmdDTO)
                .toList();
    }

    public EtatCmdDTO updateEtatCmd(Long id, EtatCmdDTO etatCmdDTO) {
        EtatCmd existingEtatCmd = etatCmdRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("EtatCmd not found"));
        EtatCmd updatedEtatCmd = etatCmdMapper.etatCmdDTOToEtatCmd(etatCmdDTO);
        updatedEtatCmd.setId(id);
        updatedEtatCmd = etatCmdRepository.save(updatedEtatCmd);
        return etatCmdMapper.etatCmdToEtatCmdDTO(updatedEtatCmd);
    }

    public void deleteEtatCmd(Long id) {
        EtatCmd etatCmd = etatCmdRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("EtatCmd not found"));
        etatCmdRepository.delete(etatCmd);
    }
}
