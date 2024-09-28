// ProgressionController.java
package com.forcen.edaara.controller;

import com.forcen.edaara.dto.ProgressionRequestDTO;
import com.forcen.edaara.dto.response.ProgressionResponseDTO;
import com.forcen.edaara.service.ProgressionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/progressions")
public class ProgressionController {

    private final ProgressionService progressionService;

    // Récupérer toutes les progressions
    @GetMapping
    public ResponseEntity<List<ProgressionResponseDTO>> getAllProgressions() {
        return ResponseEntity.ok(progressionService.getAllProgressions());
    }

    // Récupérer une progression par ID
    @GetMapping("/{id}")
    public ResponseEntity<ProgressionResponseDTO> getProgressionById(@PathVariable Long id) {
        ProgressionResponseDTO responseDTO = progressionService.getProgressionById(id);
        return ResponseEntity.ok(responseDTO);
    }

    // Créer une nouvelle progression
    @PostMapping
    public ResponseEntity<ProgressionResponseDTO> createProgression(@RequestBody ProgressionRequestDTO requestDTO) {
        ProgressionResponseDTO responseDTO = progressionService.createProgression(requestDTO);
        return ResponseEntity.status(201).body(responseDTO);
    }

    // Mettre à jour une progression existante
    @PutMapping("/{id}")
    public ResponseEntity<ProgressionResponseDTO> updateProgression(@PathVariable Long id,@RequestBody ProgressionRequestDTO requestDTO) {
        ProgressionResponseDTO responseDTO = progressionService.updateProgression(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    // Supprimer une progression
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgression(@PathVariable Long id) {
        progressionService.deleteProgression(id);
        return ResponseEntity.noContent().build();
    }
}
