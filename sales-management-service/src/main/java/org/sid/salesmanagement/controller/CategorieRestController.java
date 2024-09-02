package org.sid.salesmanagement.controller;

import org.sid.salesmanagement.security.dto.CategorieDTO;
import org.sid.salesmanagement.security.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieRestController {
    @Autowired
    private CategorieService categorieService;

    @PostMapping
    public ResponseEntity<CategorieDTO> createCategorie(@RequestBody CategorieDTO categorieDTO) {
        CategorieDTO createdCategorie = categorieService.createCategorie(categorieDTO);
        return ResponseEntity.ok(createdCategorie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategorieDTO> getCategorieById(@PathVariable Long id) {
        CategorieDTO categorieDTO = categorieService.getCategorieById(id);
        return ResponseEntity.ok(categorieDTO);
    }

    @GetMapping
    public ResponseEntity<List<CategorieDTO>> getAllCategories() {
        List<CategorieDTO> categoriesDTO = categorieService.getAllCategories();
        return ResponseEntity.ok(categoriesDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategorieDTO> updateCategorie(@PathVariable Long id, @RequestBody CategorieDTO categorieDTO) {
        CategorieDTO updatedCategorie = categorieService.updateCategorie(id, categorieDTO);
        return ResponseEntity.ok(updatedCategorie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable Long id) {
        categorieService.deleteCategorie(id);
        return ResponseEntity.noContent().build();
    }
}
