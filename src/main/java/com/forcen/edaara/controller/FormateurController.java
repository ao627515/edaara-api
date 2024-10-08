package com.forcen.edaara.controller;

import com.forcen.edaara.dto.FormateurRequestDTO;
import com.forcen.edaara.dto.response.FormateurResponseDTO;
import com.forcen.edaara.service.FormateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formateurs")
@RequiredArgsConstructor
public class FormateurController {

    private final FormateurService formateurService;

    // CREATE (Ajouter un nouveau formateur)
    @PostMapping
    public ResponseEntity<FormateurResponseDTO> ajouterFormateur(@RequestBody FormateurRequestDTO formateurRequestDTO) {
        FormateurResponseDTO nouveauFormateur = formateurService.ajouterFormateur(formateurRequestDTO);
        return new ResponseEntity<>(nouveauFormateur, HttpStatus.CREATED);
    }

    // READ (Récupérer un formateur par ID)
    @GetMapping("/{id}")
    public ResponseEntity<FormateurResponseDTO> obtenirFormateurParId(@PathVariable Long id) {
        FormateurResponseDTO formateur = formateurService.obtenirFormateurParId(id);
        return new ResponseEntity<>(formateur, HttpStatus.OK);
    }

    // READ ALL (Récupérer tous les formateurs)
    @GetMapping
    public ResponseEntity<List<FormateurResponseDTO>> obtenirTousLesFormateurs() {
        List<FormateurResponseDTO> formateurs = formateurService.obtenirTousLesFormateurs();
        return new ResponseEntity<>(formateurs, HttpStatus.OK);
    }

    // UPDATE (Modifier un formateur par ID)
    @PutMapping("/{id}")
    public ResponseEntity<FormateurResponseDTO> modifierFormateur(@PathVariable Long id, @RequestBody FormateurRequestDTO formateurRequestDTO) {
        FormateurResponseDTO formateurMisAJour = formateurService.modifierFormateur(id, formateurRequestDTO);
        return new ResponseEntity<>(formateurMisAJour, HttpStatus.OK);
    }

    // DELETE (Supprimer un formateur par ID)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerFormateur(@PathVariable Long id) {
        formateurService.supprimerFormateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
