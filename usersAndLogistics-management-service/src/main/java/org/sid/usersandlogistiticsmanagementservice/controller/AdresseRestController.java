package org.sid.usersandlogistiticsmanagementservice.controller;

import org.sid.usersandlogistiticsmanagementservice.security.dto.AdresseDTO;
import org.sid.usersandlogistiticsmanagementservice.security.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adresses")

public class AdresseRestController {

    @Autowired
    private AdresseService adresseService;

    @PostMapping
    public ResponseEntity<AdresseDTO> createAdresse(@RequestBody AdresseDTO adresseDTO) {
        AdresseDTO createdAdresse = adresseService.createAdresse(adresseDTO);
        return ResponseEntity.ok(createdAdresse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdresseDTO> getAdresseById(@PathVariable Integer id) {
        AdresseDTO adresseDTO = adresseService.getAdresseById(id);
        return ResponseEntity.ok(adresseDTO);
    }

    @GetMapping
    public ResponseEntity<List<AdresseDTO>> getAllAdresses() {
        List<AdresseDTO> adressesDTO = adresseService.getAllAdresses();
        return ResponseEntity.ok(adressesDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdresseDTO> updateAdresse(@PathVariable Integer id, @RequestBody AdresseDTO adresseDTO) {
        AdresseDTO updatedAdresse = adresseService.updateAdresse(id,adresseDTO);
        return ResponseEntity.ok(updatedAdresse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdresse(@PathVariable Integer id) {
        adresseService.deleteAdresse(id);
        return ResponseEntity.noContent().build();
    }
}
