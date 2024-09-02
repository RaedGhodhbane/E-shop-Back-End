package org.sid.usersandlogistiticsmanagementservice.controller;

import org.apache.coyote.Response;
import org.sid.usersandlogistiticsmanagementservice.security.dto.LivraisonDTO;
import org.sid.usersandlogistiticsmanagementservice.security.service.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livraisons")
public class LivraisonRestController {
    @Autowired
    private LivraisonService livraisonService;

    @PostMapping
    public ResponseEntity<LivraisonDTO> createLivraison(@RequestBody LivraisonDTO livraisonDTO) {
        LivraisonDTO createdLivraison = livraisonService.createLivraison(livraisonDTO);
        return ResponseEntity.ok(createdLivraison);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivraisonDTO> getLivraisonById(@PathVariable Long id) {
        LivraisonDTO livraisonDTO = livraisonService.getLivraisonById(id);
        return ResponseEntity.ok(livraisonDTO);
    }

    @GetMapping
    public ResponseEntity<List<LivraisonDTO>> getAllLivraison() {
        List<LivraisonDTO> livraisonsDTO = livraisonService.getAllLivraisons();
        return ResponseEntity.ok(livraisonsDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivraisonDTO> updateLivraison(@PathVariable Long id, @RequestBody LivraisonDTO livraisonDTO) {
        LivraisonDTO updatedLivraison = livraisonService.updateLivraison(id,livraisonDTO);
        return ResponseEntity.ok(updatedLivraison);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivraison(@PathVariable Long id) {
        livraisonService.deleteLivraison(id);
        return ResponseEntity.noContent().build();
    }
}
