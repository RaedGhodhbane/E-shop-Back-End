package org.sid.salesmanagement.security.service;

import org.sid.salesmanagement.entities.Commande;
import org.sid.salesmanagement.repository.CommandeRepository;
import org.sid.salesmanagement.security.dto.CommandeDTO;
import org.sid.salesmanagement.security.mapper.CommandeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private CommandeMapper commandeMapper;

    public CommandeDTO createCommande(CommandeDTO commandeDTO) {
        Commande commande = commandeMapper.commandeDTOToCommande(commandeDTO);
        Commande savedCommande = commandeRepository.save(commande);
        return commandeMapper.commandeToCommandeDTO(savedCommande);
    }

    public CommandeDTO getCommandeById(Long id) {
        Commande commande = commandeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Commande not found"));
        return commandeMapper.commandeToCommandeDTO(commande);
    }

    public List<CommandeDTO> getAllCommandes() {
        return commandeRepository.findAll().stream()
                .map(commandeMapper::commandeToCommandeDTO)
                .toList();
    }

    public CommandeDTO updateCommande(Long id, CommandeDTO commandeDTO) {
        Commande existingCommande = commandeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Commande not found"));
        Commande updatedCommande = commandeMapper.commandeDTOToCommande(commandeDTO);
        updatedCommande.setId(id);
        updatedCommande = commandeRepository.save(updatedCommande);
        return commandeMapper.commandeToCommandeDTO(updatedCommande);
    }

    public void deleteCommande(Long id) {
        Commande commande = commandeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Commande not found"));
        commandeRepository.delete(commande);
    }
}
