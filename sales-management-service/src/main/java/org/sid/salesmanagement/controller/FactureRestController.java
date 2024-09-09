package org.sid.salesmanagement.controller;

import org.sid.salesmanagement.security.dto.FactureDTO;
import org.sid.salesmanagement.security.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/factures")
public class FactureRestController {
    @Autowired
    private FactureService factureService;

    @PostMapping
    public ResponseEntity<FactureDTO> createFacture(@RequestBody FactureDTO factureDTO) {
        FactureDTO createdFacture = factureService.createFacture(factureDTO);
        return ResponseEntity.ok(createdFacture);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FactureDTO> getFactureById(@PathVariable Long id) {
        FactureDTO factureDTO = factureService.getFactureById(id);
        return ResponseEntity.ok(factureDTO);
    }

}
