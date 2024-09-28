package com.forcen.edaara.service.impl;

import com.forcen.edaara.dto.EtudiantRequestDTO;
import com.forcen.edaara.dto.response.EtudiantResponseDTO;
import com.forcen.edaara.enums.Role;
import com.forcen.edaara.mapper.EtudiantMapper;
import com.forcen.edaara.model.Etudiant;
import com.forcen.edaara.model.Parcours;
import com.forcen.edaara.repository.EtudiantRepository;
import com.forcen.edaara.service.EtudiantService;
import com.forcen.edaara.service.ParcoursService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {

  private final EtudiantRepository etudiantRepository;
  private final EtudiantMapper etudiantMapper;

  @Override
  public EtudiantResponseDTO creerEtudiant(EtudiantRequestDTO etudiantRequestDTO) {
    Etudiant etudiant = this.etudiantMapper.toEntity(etudiantRequestDTO);
    etudiant.setRole(Role.ETUDIANT);
    etudiant = this.etudiantRepository.save(etudiant);
    return this.etudiantMapper.toDto(etudiant);
  }

  @Override
  public List<EtudiantResponseDTO> listeEtudiant() {
    return etudiantMapper.toDtoList(etudiantRepository.findAll());
  }

  @Override
  public EtudiantResponseDTO modifierEtudiant(Long id, EtudiantRequestDTO etudiantRequestDTO) {
    Etudiant existingStudent =
        etudiantRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Étudiant avec l'ID " + id + " introuvable"));

    Etudiant updatedStudent = etudiantMapper.toEntity(etudiantRequestDTO);
    updatedStudent.setIdUtilisateur(existingStudent.getIdUtilisateur());

    Etudiant savedStudent = etudiantRepository.save(updatedStudent);
    return etudiantMapper.toDto(savedStudent);
  }

  @Override
  public void supprimerEtudiant(Long id) {
    Etudiant existEtudiant =
        etudiantRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Étudiant avec l'ID " + id + " introuvable"));
    etudiantRepository.delete(existEtudiant);
  }

  @Override
  public EtudiantResponseDTO obtenirEtudiantParId(Long id) {
    Etudiant existEtudiant =
        etudiantRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Étudiant avec l'ID " + id + " introuvable"));
    return etudiantMapper.toDto(existEtudiant);
  }

  @Override
  public Etudiant obtenirUnParcoursParSonId(Long id) {
    return etudiantRepository
        .findById(id)
        .orElseThrow(
            () -> new EntityNotFoundException("Étudiant avec l'ID " + id + " introuvable"));
  }

  @Override
  public EtudiantResponseDTO EtudiantAResponseDto(Etudiant etudiant) {
    return etudiantMapper.toDto(etudiant);
  }

  @Override
  public List<EtudiantResponseDTO> ListEtudiantAListResponseDto(List<Etudiant> etudiantList) {
    return etudiantMapper.toDtoList(etudiantList);
  }

  @Override
  public Etudiant RequestDtoAEtudiant(EtudiantRequestDTO requestDTO) {
    return etudiantMapper.toEntity(requestDTO);
  }

  @Override
  public EtudiantRequestDTO EtudiantARequestDTO(Etudiant etudiant) {
    return etudiantMapper.toRequestDto(etudiant);
  }

  @Override
  public EtudiantResponseDTO enregistrerEtudiantDansUnParcour(Long etudiantId, Parcours parcours) {
    Etudiant etudiant = obtenirUnParcoursParSonId(etudiantId);
    etudiant.setParcours(parcours);
    Etudiant updatedEtudiant = etudiantRepository.save(etudiant);
    return etudiantMapper.toDto(updatedEtudiant);
  }
}
