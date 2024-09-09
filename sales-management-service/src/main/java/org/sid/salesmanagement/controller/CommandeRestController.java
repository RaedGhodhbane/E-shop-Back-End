package org.sid.salesmanagement.controller;

import org.sid.salesmanagement.security.dto.CommandeDTO;
import org.sid.salesmanagement.security.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeRestController {
    @Autowired
    private CommandeService commandeService;

    @PostMapping
    public ResponseEntity<CommandeDTO> createCommande(@RequestBody CommandeDTO commandeDTO) {
        CommandeDTO createdCommande = commandeService.createCommande(commandeDTO);
        return ResponseEntity.ok(createdCommande);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeDTO> getCommandeById(@PathVariable Long id) {
        CommandeDTO commandeDTO = commandeService.getCommandeById(id);
        return ResponseEntity.ok(commandeDTO);
    }

    @GetMapping
    public ResponseEntity<List<CommandeDTO>> getAllCommandes() {
        List<CommandeDTO> commandesDTO = commandeService.getAllCommandes();
        return ResponseEntity.ok(commandesDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandeDTO> updateCommande(@PathVariable Long id, @RequestBody CommandeDTO commandeDTO) {
        CommandeDTO updatedCommande = commandeService.updateCommande(id, commandeDTO);
        return ResponseEntity.ok(updatedCommande);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
        return ResponseEntity.noContent().build();
    }

}
