package com.forcen.edaara.service.impl;

import com.forcen.edaara.Exception.EntityNotFoundException;
import com.forcen.edaara.dto.ParcoursRequestDTO;
import com.forcen.edaara.dto.response.EtudiantResponseDTO;
import com.forcen.edaara.dto.response.ParcourResponseDTO;
import com.forcen.edaara.mapper.EtudiantMapper;
import com.forcen.edaara.mapper.ParcoursMapper;
import com.forcen.edaara.model.Parcours;
import com.forcen.edaara.repository.ParcoursRepository;
import com.forcen.edaara.service.EtudiantParcoursService;
import com.forcen.edaara.service.ParcoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParcoursServiceImpl implements ParcoursService {

  private final ParcoursRepository parcoursRepository;
  private final ParcoursMapper parcoursMapper;
  private final EtudiantMapper etudiantMapper;

  @Override
  public ParcourResponseDTO creerParcours(ParcoursRequestDTO parcoursRequestDTO) {
    Parcours parcours = parcoursMapper.toEntity(parcoursRequestDTO);
    parcours = parcoursRepository.save(parcours);
    return parcoursMapper.toDto(parcours);
  }

  @Override
  public List<ParcourResponseDTO> listeParcours() {
    return parcoursRepository.findAll().stream()
        .map(parcoursMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public ParcourResponseDTO modifierParcours(Long id, ParcoursRequestDTO parcoursRequestDTO) {
    Parcours existingParcours = getParcoursById(id);
    Parcours updatedParcours = parcoursMapper.toEntity(parcoursRequestDTO);
    updatedParcours.setIdParcours(existingParcours.getIdParcours());
    return parcoursMapper.toDto(parcoursRepository.save(updatedParcours));
  }

  @Override
  public void supprimerParcours(Long id) {
    Parcours parcours = getParcoursById(id);
    parcoursRepository.delete(parcours);
  }

  @Override
  public ParcourResponseDTO obtenirParcoursParId(Long id) {
    Parcours parcours = getParcoursById(id);
    return parcoursMapper.toDto(parcours);
  }

  @Override
  public List<EtudiantResponseDTO> obtenirToutLesEtudiantDuParcours(Long id) {
    Parcours parcours = getParcoursById(id);
    return etudiantMapper.toDtoList(parcours.getEtudiants());
  }

  @Override
  public Parcours obtenirUnParcoursParSonId(Long id) {
    return this.getParcoursById(id);
  }

  private Parcours getParcoursById(Long id) {
    return parcoursRepository
        .findById(id)
        .orElseThrow(
            () ->
                new EntityNotFoundException(
                    "Le parcours avec l'ID " + id + " est introuvable"));
  }
}
