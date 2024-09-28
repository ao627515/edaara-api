package com.forcen.edaara.service;

import com.forcen.edaara.dto.EvaluationRequestDTO;
import com.forcen.edaara.dto.response.EvaluationResponseDTO;
import com.forcen.edaara.model.Evaluation;

import java.util.List;

public interface EvaluationService {
    List<EvaluationResponseDTO> getAllEvaluations();
    EvaluationResponseDTO getEvaluationById(Long id);
    EvaluationResponseDTO createEvaluation(EvaluationRequestDTO requestDTO);
    EvaluationResponseDTO updateEvaluation(Long id, EvaluationRequestDTO requestDTO);
    Void deleteEvaluation(Long id);
    Evaluation findById(Long id);
}
