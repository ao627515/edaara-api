package com.forcen.edaara.service.impl;

import com.forcen.edaara.Exception.EntityNotFoundException;
import com.forcen.edaara.dto.ProgressionRequestDTO;
import com.forcen.edaara.dto.response.ProgressionResponseDTO;
import com.forcen.edaara.mapper.ProgressionMapper;
import com.forcen.edaara.model.Cours;
import com.forcen.edaara.model.Etudiant;
import com.forcen.edaara.model.Progression;
import com.forcen.edaara.repository.CoursRepository;
import com.forcen.edaara.repository.EtudiantRepository;
import com.forcen.edaara.repository.ProgressionsRepository;
import com.forcen.edaara.service.CoursService;
import com.forcen.edaara.service.EtudiantService;
import com.forcen.edaara.service.ProgressionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProgressionServiceImpl implements ProgressionService {

  private final ProgressionsRepository progressionsRepository;
  private final ProgressionMapper progressionMapper;
  private final CoursService coursService;
  private final EtudiantService etudiantService;

  @Override
  public List<ProgressionResponseDTO> getAllProgressions() {
    return this.progressionMapper.toResponseDtoList(this.progressionsRepository.findAll());
  }

  @Override
  public ProgressionResponseDTO getProgressionById(Long id) {
    Progression progression = this.getById(id);
    return this.progressionMapper.toResponseDto(progression);
  }

  @Override
  public ProgressionResponseDTO createProgression(ProgressionRequestDTO requestDTO) {
    Progression progression = this.progressionMapper.toModel(requestDTO);

    Cours cours =
        this.coursService.findCoursById(requestDTO.getId_cours());

    Etudiant etudiant =
        this.etudiantService.obtenirUnParcoursParSonId(requestDTO.getId_etudiant());
    progression.setCours(cours);
    progression.setEtudiant(etudiant);

    progression = this.progressionsRepository.save(progression);

    return this.progressionMapper.toResponseDto(progression);
  }

  @Override
  public ProgressionResponseDTO updateProgression(Long id, ProgressionRequestDTO requestDTO) {
    Progression upadated = this.getById(id);
    Cours cours =
            this.coursService.findCoursById(requestDTO.getId_cours());

    Etudiant etudiant =
            this.etudiantService.obtenirUnParcoursParSonId(requestDTO.getId_etudiant());

    upadated.setCours(cours);
    upadated.setEtudiant(etudiant);
    upadated.setPourcentage(requestDTO.getPourcentage());

    upadated = this.progressionsRepository.save(upadated);
    return this.progressionMapper.toResponseDto(upadated);
  }

  @Override
  public Void deleteProgression(Long id) {
    Progression progression = this.getById(id);
    this.progressionsRepository.delete(progression);
    return null;
  }

  private Progression getById(Long id) {
    return progressionsRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Progression not found"));
  }
}
