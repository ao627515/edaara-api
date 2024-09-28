package com.forcen.edaara.service.impl;

import com.forcen.edaara.Exception.EntityNotFoundException;
import com.forcen.edaara.dto.AdministrateurRequestDTO;
import com.forcen.edaara.dto.response.AdministrateurResponseDTO;
import com.forcen.edaara.enums.Role;
import com.forcen.edaara.mapper.AdministrateurMapper;
import com.forcen.edaara.model.Administrateur;
import com.forcen.edaara.repository.AdministrateurRepository;
import com.forcen.edaara.service.AdministrateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdministrateurServiceImpl implements AdministrateurService {
  private final AdministrateurRepository administrateurRepository;
  private final AdministrateurMapper administrateurMapper;

  @Transactional
  @Override
  public AdministrateurResponseDTO ajouterAdministrateur(AdministrateurRequestDTO dto) {
    Administrateur administrateur = this.administrateurMapper.toEntity(dto);
    administrateur.setRole(Role.ADMINISTRATEUR);
    administrateur = this.administrateurRepository.save(administrateur);

    return this.administrateurMapper.toDto(administrateur);
  }

  @Transactional
  @Override
  public AdministrateurResponseDTO modifierAdministrateur(Long id_administrateur, AdministrateurRequestDTO dto) {
    Administrateur dbAdministrateur = this.getById(id_administrateur);
//
//    dbAdministrateur.setNom(dto.getNom());
//    dbAdministrateur.setPrenom(dto.getPrenom());
//    dbAdministrateur.setEmail(dto.getEmail());

    dbAdministrateur = this.administrateurMapper.toEntity(this.administrateurMapper.toEntity(dto));
    dbAdministrateur.setIdUtilisateur(id_administrateur);
    // Mise à jour des autres champs si nécessaire

    this.administrateurRepository.save(dbAdministrateur);
    return this.administrateurMapper.toDto(dbAdministrateur);
  }

  @Transactional
  @Override
  public void supprimerAdministrateur(Long id_administrateur) {
    Administrateur administrateur = this.getById(id_administrateur);
    this.administrateurRepository.delete(administrateur);
  }

  @Override
  public List<AdministrateurResponseDTO> obtenirTousLesAdministrateur() {
    return this.administrateurRepository.findAll()
            .stream()
            .map(this.administrateurMapper::toDto)
            .collect(Collectors.toList());
  }

  @Override
  public AdministrateurResponseDTO obtenirAdministrateurParId(Long id_administrateur) {
    Administrateur administrateur = this.getById(id_administrateur);
    return this.administrateurMapper.toDto(administrateur);
  }

  private Administrateur getById(Long id) {
    return this.administrateurRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Administrateur avec l'ID " + id + " n'existe pas"));
  }
}
