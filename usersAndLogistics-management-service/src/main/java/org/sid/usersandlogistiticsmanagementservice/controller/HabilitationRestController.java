package org.sid.usersandlogistiticsmanagementservice.controller;

import org.apache.coyote.Response;
import org.sid.usersandlogistiticsmanagementservice.security.dto.HabilitationDTO;
import org.sid.usersandlogistiticsmanagementservice.security.service.HabilitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilitations")
public class HabilitationRestController {

    @Autowired
    private HabilitationService habilitationService;

    @PostMapping
    public ResponseEntity<HabilitationDTO> createHabilitation(@RequestBody HabilitationDTO habilitationDTO) {
        HabilitationDTO createdHabilitation = habilitationService.createHabilitation(habilitationDTO);
        return ResponseEntity.ok(createdHabilitation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabilitationDTO> getHabilitationById(@PathVariable Integer id) {
        HabilitationDTO habilitationDTO = habilitationService.getHabilitationById(id);
        return ResponseEntity.ok(habilitationDTO);
    }

    @GetMapping
    public ResponseEntity<List<HabilitationDTO>> getAllHabilitations() {
        List<HabilitationDTO> habilitationsDTO = habilitationService.getAllHabilitations();
        return ResponseEntity.ok(habilitationsDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HabilitationDTO> updateHabilitation(@PathVariable Integer id, @RequestBody HabilitationDTO habilitationDTO) {
        HabilitationDTO updatedHabilitation = habilitationService.updateHabilitation(id,habilitationDTO);
        return ResponseEntity.ok(updatedHabilitation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabilitation(@PathVariable Integer id) {
        habilitationService.deleteHabilitation(id);
        return ResponseEntity.noContent().build();
    }

}
