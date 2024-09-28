package com.forcen.edaara.service.impl;

import com.forcen.edaara.Exception.EntityNotFoundException;
import com.forcen.edaara.dto.EvaluationRequestDTO;
import com.forcen.edaara.dto.response.EvaluationResponseDTO;
import com.forcen.edaara.mapper.EvaluationMapper;
import com.forcen.edaara.model.Etudiant;
import com.forcen.edaara.model.Evaluation;
import com.forcen.edaara.repository.EvaluationRepository;
import com.forcen.edaara.service.EtudiantService;
import com.forcen.edaara.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationServiceImpl implements EvaluationService {

  private final EvaluationRepository evaluationRepository;
  private final EvaluationMapper evaluationMapper;
  private final EtudiantService etudiantService;

  @Override
  public List<EvaluationResponseDTO> getAllEvaluations() {
    return evaluationMapper.toResponseDtoList(evaluationRepository.findAll());
  }

  @Override
  public EvaluationResponseDTO getEvaluationById(Long id) {
    Evaluation evaluation = findById(id);
    return evaluationMapper.toResponseDto(evaluation);
  }

  @Override
  public EvaluationResponseDTO createEvaluation(EvaluationRequestDTO requestDTO) {
    Evaluation evaluation = evaluationMapper.toModel(requestDTO);
    updateEvaluationDetails(evaluation, requestDTO);
    evaluation = evaluationRepository.save(evaluation);
    return evaluationMapper.toResponseDto(evaluation);
  }

  @Override
  public EvaluationResponseDTO updateEvaluation(Long id, EvaluationRequestDTO requestDTO) {
    Evaluation evaluation = findById(id);
    updateEvaluationDetails(evaluation, requestDTO);
    evaluation = evaluationRepository.save(evaluation);
    return evaluationMapper.toResponseDto(evaluation);
  }

  @Override
  public Void deleteEvaluation(Long id) {
    Evaluation evaluation = findById(id);
    evaluationRepository.delete(evaluation);
    return null;
  }

  @Override
  public Evaluation findById(Long id) {
    return evaluationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Evaluation not found"));
  }

  // Méthode privée pour mettre à jour les détails de l'évaluation
  private void updateEvaluationDetails(Evaluation evaluation, EvaluationRequestDTO requestDTO) {
    Etudiant etudiant = etudiantService.obtenirUnParcoursParSonId(requestDTO.getEtudiant_id());
    evaluation.setEtudiant(etudiant);
    evaluation.setDateEvaluation(LocalDate.now());
  }
}
