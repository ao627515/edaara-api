package com.forcen.edaara.controller;

import com.forcen.edaara.dto.EvaluationRequestDTO;
import com.forcen.edaara.dto.response.EvaluationResponseDTO;
import com.forcen.edaara.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService evaluationService;

    @GetMapping
    public ResponseEntity<List<EvaluationResponseDTO>> getAllEvaluations() {
        List<EvaluationResponseDTO> evaluations = evaluationService.getAllEvaluations();
        return ResponseEntity.ok(evaluations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluationResponseDTO> getEvaluationById(@PathVariable Long id) {
        EvaluationResponseDTO evaluation = evaluationService.getEvaluationById(id);
        return ResponseEntity.ok(evaluation);
    }

    @PostMapping
    public ResponseEntity<EvaluationResponseDTO> createEvaluation(@RequestBody EvaluationRequestDTO requestDTO) {
        EvaluationResponseDTO createdEvaluation = evaluationService.createEvaluation(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvaluation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluationResponseDTO> updateEvaluation(@PathVariable Long id, @RequestBody EvaluationRequestDTO requestDTO) {
        EvaluationResponseDTO updatedEvaluation = evaluationService.updateEvaluation(id, requestDTO);
        return ResponseEntity.ok(updatedEvaluation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable Long id) {
        evaluationService.deleteEvaluation(id);
        return ResponseEntity.noContent().build();
    }
}
