package org.sid.salesmanagement.controller;

import org.sid.salesmanagement.security.dto.MarqueDTO;
import org.sid.salesmanagement.security.service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marques")
public class MarqueRestController {

    @Autowired
    private MarqueService marqueService;

    // Créer une nouvelle marque
    @PostMapping
    public ResponseEntity<MarqueDTO> createMarque(@RequestBody MarqueDTO marqueDTO) {
        MarqueDTO createdMarque = marqueService.createMarque(marqueDTO);
        return ResponseEntity.ok(createdMarque);
    }

    // Obtenir une marque par son ID
    @GetMapping("/{id}")
    public ResponseEntity<MarqueDTO> getMarqueById(@PathVariable Long id) {
        MarqueDTO marqueDTO = marqueService.getMarqueById(id);
        return ResponseEntity.ok(marqueDTO);
    }

    // Obtenir toutes les marques
    @GetMapping
    public ResponseEntity<List<MarqueDTO>> getAllMarques() {
        List<MarqueDTO> marquesDTO = marqueService.getAllMarques();
        return ResponseEntity.ok(marquesDTO);
    }

    // Mettre à jour une marque existante
    @PutMapping("/{id}")
    public ResponseEntity<MarqueDTO> updateMarque(@PathVariable Long id, @RequestBody MarqueDTO marqueDTO) {
        MarqueDTO updatedMarque = marqueService.updateMarque(id, marqueDTO);
        return ResponseEntity.ok(updatedMarque);
    }

    // Supprimer une marque
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarque(@PathVariable Long id) {
        marqueService.deleteMarque(id);
        return ResponseEntity.noContent().build();
    }
}
