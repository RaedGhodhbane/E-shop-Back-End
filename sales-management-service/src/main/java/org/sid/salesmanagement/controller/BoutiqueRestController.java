package org.sid.salesmanagement.controller;

import org.sid.salesmanagement.security.dto.BoutiqueDTO;
import org.sid.salesmanagement.security.service.BoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boutiques")
public class BoutiqueRestController {
    @Autowired
    private BoutiqueService boutiqueService;
    @PostMapping
    public ResponseEntity<BoutiqueDTO> createBoutique(@RequestBody BoutiqueDTO boutiqueDTO) {
        BoutiqueDTO createdBoutique = boutiqueService.createBoutique(boutiqueDTO);
        return ResponseEntity.ok(createdBoutique);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoutiqueDTO> getBoutiqueById(@PathVariable Long id) {
        BoutiqueDTO boutiqueDTO = boutiqueService.getBoutiqueById(id);
        return ResponseEntity.ok(boutiqueDTO);
    }

    @GetMapping
    public ResponseEntity<List<BoutiqueDTO>> getAllBoutiques() {
        List<BoutiqueDTO> boutiquesDTO = boutiqueService.getAllBoutiques();
        return ResponseEntity.ok(boutiquesDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoutiqueDTO> updateBoutique(@PathVariable Long id, @RequestBody BoutiqueDTO boutiqueDTO) {
        BoutiqueDTO updatedBoutique = boutiqueService.updateBoutique(id, boutiqueDTO);
        return ResponseEntity.ok(updatedBoutique);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoutique(@PathVariable Long id) {
        boutiqueService.deleteBoutique(id);
        return ResponseEntity.noContent().build();
    }
}
