package org.sid.usersandlogistiticsmanagementservice.controller;

import org.sid.usersandlogistiticsmanagementservice.security.dto.ModeLivraisonDTO;
import org.sid.usersandlogistiticsmanagementservice.security.service.ModeLivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modeLivraisons")
public class ModeLivraisonRestController {
    @Autowired
    private ModeLivraisonService modeLivraisonService;

    @PostMapping
    public ResponseEntity<ModeLivraisonDTO> createModeLivraison(@RequestBody ModeLivraisonDTO modeLivraisonDTO) {
        ModeLivraisonDTO createdModeLivraison = modeLivraisonService.createModeLivraison(modeLivraisonDTO);
        return ResponseEntity.ok(createdModeLivraison);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeLivraisonDTO> getModeLivraisonById(@PathVariable Long id) {
        ModeLivraisonDTO modeLivraisonDTO = modeLivraisonService.getModeLivraisonById(id);
        return ResponseEntity.ok(modeLivraisonDTO);
    }

    @GetMapping
    public ResponseEntity<List<ModeLivraisonDTO>> getAllModeLivraison() {
        List<ModeLivraisonDTO> modeLivraisonsDTO = modeLivraisonService.getAllModeLivraisons();
        return ResponseEntity.ok(modeLivraisonsDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeLivraisonDTO> updateModeLivraison(@PathVariable Long id, @RequestBody ModeLivraisonDTO modeLivraisonDTO) {
        ModeLivraisonDTO updatedModeLivraison = modeLivraisonService.updateModeLivraison(id,modeLivraisonDTO);
        return ResponseEntity.ok(updatedModeLivraison);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivraison(@PathVariable Long id) {
        modeLivraisonService.deleteModeLivraison(id);
        return ResponseEntity.noContent().build();
    }
}
