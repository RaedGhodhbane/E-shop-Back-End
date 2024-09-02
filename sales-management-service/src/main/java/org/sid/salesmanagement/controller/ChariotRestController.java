package org.sid.salesmanagement.controller;

import org.sid.salesmanagement.security.dto.ChariotDTO;
import org.sid.salesmanagement.security.dto.MarqueDTO;
import org.sid.salesmanagement.security.service.ChariotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chariots")
public class ChariotRestController {
    @Autowired
    private ChariotService chariotService;

    @PostMapping
    public ResponseEntity<ChariotDTO> createChariot(@RequestBody ChariotDTO chariotDTO) {
        ChariotDTO createdChariot = chariotService.createChariot(chariotDTO);
        return ResponseEntity.ok(createdChariot);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ChariotDTO> getChariotById(@PathVariable Long id) {
        ChariotDTO chariotDTO = chariotService.getChariotById(id);
        return ResponseEntity.ok(chariotDTO);
    }

    @GetMapping
    public ResponseEntity<List<ChariotDTO>> getAllChariots() {
        List<ChariotDTO> chariotsDTO = chariotService.getAllChariots();
        return ResponseEntity.ok(chariotsDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChariotDTO> updateChariot(@PathVariable Long id, @RequestBody ChariotDTO chariotDTO) {
        ChariotDTO updatedChariot = chariotService.updateChariot(id, chariotDTO);
        return ResponseEntity.ok(updatedChariot);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChariot(@PathVariable Long id) {
        chariotService.deleteChariot(id);
        return ResponseEntity.noContent().build();
    }
}
