package com.forcen.edaara.service;

import com.forcen.edaara.dto.EtudiantRequestDTO;
import com.forcen.edaara.dto.response.EtudiantResponseDTO;
import com.forcen.edaara.model.Etudiant;
import com.forcen.edaara.model.Parcours;

import java.util.List;

public interface EtudiantService {
       EtudiantResponseDTO creerEtudiant(EtudiantRequestDTO etudiantRequestDTO);
       List<EtudiantResponseDTO> listeEtudiant();
       EtudiantResponseDTO modifierEtudiant(Long id, EtudiantRequestDTO etudiantRequestDTO);
       void supprimerEtudiant(Long id);
       EtudiantResponseDTO obtenirEtudiantParId(Long id);
       Etudiant obtenirUnParcoursParSonId(Long id);
       EtudiantResponseDTO EtudiantAResponseDto(Etudiant etudiant);
       Etudiant RequestDtoAEtudiant(EtudiantRequestDTO requestDTO);
       List<EtudiantResponseDTO> ListEtudiantAListResponseDto(List<Etudiant> etudiantList);
       EtudiantRequestDTO  EtudiantARequestDTO(Etudiant etudiant);
       EtudiantResponseDTO enregistrerEtudiantDansUnParcour(Long etudiantId, Parcours parcours);
}
