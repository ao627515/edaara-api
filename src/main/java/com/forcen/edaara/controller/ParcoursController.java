package com.forcen.edaara.controller;

import com.forcen.edaara.dto.ParcoursRequestDTO;
import com.forcen.edaara.dto.response.EtudiantResponseDTO;
import com.forcen.edaara.dto.response.ParcourResponseDTO;
import com.forcen.edaara.model.Parcours;
import com.forcen.edaara.service.ParcoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcours")
@RequiredArgsConstructor
public class ParcoursController {
  private final ParcoursService parcoursService;

  @PostMapping
  public ResponseEntity<ParcourResponseDTO> creerParcours(
      @RequestBody ParcoursRequestDTO parcoursRequestDTO) {
    ParcourResponseDTO responseData = this.parcoursService.creerParcours(parcoursRequestDTO);
    return new ResponseEntity<ParcourResponseDTO>(responseData, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<ParcourResponseDTO>> listeParcours() {
    return ResponseEntity.ok(this.parcoursService.listeParcours());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ParcourResponseDTO> modifierParcours(@PathVariable Long id) {
    return ResponseEntity.ok(this.parcoursService.obtenirParcoursParId(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ParcourResponseDTO> modifierParcours(
      @PathVariable Long id, @RequestBody ParcoursRequestDTO parcoursRequestDTO) {
    return ResponseEntity.ok(this.parcoursService.modifierParcours(id, parcoursRequestDTO));
  }

  @GetMapping("/{id}/etudiants")
  public ResponseEntity<List<EtudiantResponseDTO>> obtenirToutLesEtudiantDuParcours(
      @PathVariable Long id) {
    List<EtudiantResponseDTO> responseDTOList =
        this.parcoursService.obtenirToutLesEtudiantDuParcours(id);
    return ResponseEntity.ok(responseDTOList);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> supprimerParcours(@PathVariable Long id) {
    this.parcoursService.supprimerParcours(id);
    return ResponseEntity.noContent().build();
  }
}
