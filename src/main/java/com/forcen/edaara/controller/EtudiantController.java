package com.forcen.edaara.controller;

import com.forcen.edaara.dto.EtudiantRequestDTO;
import com.forcen.edaara.dto.response.EtudiantResponseDTO;
import com.forcen.edaara.model.Parcours;
import com.forcen.edaara.service.EtudiantParcoursService;
import com.forcen.edaara.service.EtudiantService;
import com.forcen.edaara.service.ParcoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
@RequiredArgsConstructor
public class EtudiantController {

  private final EtudiantService etudiantService;
  private final EtudiantParcoursService etudiantParcoursService;

  @PostMapping
  public ResponseEntity<EtudiantResponseDTO> creerEtudiant(
      @RequestBody EtudiantRequestDTO etudiantRequestDTO) {
    EtudiantResponseDTO responseDTO = this.etudiantService.creerEtudiant(etudiantRequestDTO);
    return new ResponseEntity<EtudiantResponseDTO>(responseDTO, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<EtudiantResponseDTO>> listeEtudiant() {
    List<EtudiantResponseDTO> responseData = this.etudiantService.listeEtudiant();
    return new ResponseEntity<List<EtudiantResponseDTO>>(responseData, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<EtudiantResponseDTO> obtenirEtudiantParId(@PathVariable Long id) {
    EtudiantResponseDTO responseDTO = this.etudiantService.obtenirEtudiantParId(id);
    return ResponseEntity.ok(responseDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EtudiantResponseDTO> modifierEtudiant(
      @PathVariable Long id, @RequestBody EtudiantRequestDTO etudiantRequestDTO) {

    // Appel du service pour modifier l'étudiant
    EtudiantResponseDTO responseDTO = this.etudiantService.modifierEtudiant(id, etudiantRequestDTO);

    // Retourne la réponse avec le statut HTTP 200 OK
    return ResponseEntity.ok(responseDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> supprimerEtudiant(@PathVariable Long id) {
    // Appel du service pour supprimer l'étudiant
    this.etudiantService.supprimerEtudiant(id);

    // Retourne une réponse HTTP 204 No Content après suppression
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/{id}/parcours/{parcours_id}")
  public ResponseEntity<EtudiantResponseDTO> enregistrerEtudiantDansUnParcours(@PathVariable Long id, @PathVariable Long parcours_id) {
    EtudiantResponseDTO response = etudiantParcoursService.enregistrerEtudiantDansUnParcours(id, parcours_id);
    return ResponseEntity.ok(response);
  }
}
