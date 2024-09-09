package org.sid.salesmanagement.controller;

import org.apache.coyote.Response;
import org.sid.salesmanagement.security.dto.EtatCmdDTO;
import org.sid.salesmanagement.security.service.EtatCmdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etatcmds")
public class EtatCmdRestController {
    @Autowired
    private EtatCmdService etatCmdService;

    @PostMapping
    public ResponseEntity<EtatCmdDTO> createEtatCmd(@RequestBody EtatCmdDTO etatCmdDTO) {
        EtatCmdDTO createdEtatCmd = etatCmdService.createEtatCmd(etatCmdDTO);
        return ResponseEntity.ok(createdEtatCmd);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatCmdDTO> getEtatCmdById(@PathVariable Long id) {
        EtatCmdDTO etatCmdDTO = etatCmdService.getEtatCmdById(id);
        return ResponseEntity.ok(etatCmdDTO);
    }

    @GetMapping
    public ResponseEntity<List<EtatCmdDTO>> getAllEtatsCmds() {
        List<EtatCmdDTO> etatsCmdsDTO = etatCmdService.getAllEtatsCmds();
        return ResponseEntity.ok(etatsCmdsDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtatCmdDTO> updateEtatCmd(@PathVariable Long id, @RequestBody EtatCmdDTO etatCmdDTO) {
      EtatCmdDTO updatedEtatCmd = etatCmdService.updateEtatCmd(id, etatCmdDTO);
      return ResponseEntity.ok(updatedEtatCmd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtatCmd(@PathVariable Long id) {
        etatCmdService.deleteEtatCmd(id);
        return ResponseEntity.noContent().build();
    }

}
