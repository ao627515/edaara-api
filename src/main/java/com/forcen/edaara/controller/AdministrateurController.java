package com.forcen.edaara.controller;

import com.forcen.edaara.dto.AdministrateurRequestDTO;
import com.forcen.edaara.dto.response.AdministrateurResponseDTO;
import com.forcen.edaara.service.AdministrateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrateurs")
@RequiredArgsConstructor
public class AdministrateurController {

    private final AdministrateurService administrateurService;

    @PostMapping
    public ResponseEntity<AdministrateurResponseDTO> ajouterAdministrateur(@RequestBody AdministrateurRequestDTO dto) {
        AdministrateurResponseDTO administrateurResponseDTO = administrateurService.ajouterAdministrateur(dto);
        return ResponseEntity.ok(administrateurResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministrateurResponseDTO> modifierAdministrateur(
            @PathVariable Long id, @RequestBody AdministrateurRequestDTO dto) {
        AdministrateurResponseDTO administrateurResponseDTO = administrateurService.modifierAdministrateur(id, dto);
        return ResponseEntity.ok(administrateurResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAdministrateur(@PathVariable Long id) {
        administrateurService.supprimerAdministrateur(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AdministrateurResponseDTO>> obtenirTousLesAdministrateurs() {
        List<AdministrateurResponseDTO> administrateurs = administrateurService.obtenirTousLesAdministrateur();
        return ResponseEntity.ok(administrateurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministrateurResponseDTO> obtenirAdministrateurParId(@PathVariable Long id) {
        AdministrateurResponseDTO administrateurResponseDTO = administrateurService.obtenirAdministrateurParId(id);
        return ResponseEntity.ok(administrateurResponseDTO);
    }
}
