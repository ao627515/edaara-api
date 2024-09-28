package com.forcen.edaara.service;

import com.forcen.edaara.dto.CoursRequestDTO;
import com.forcen.edaara.dto.response.CoursResponseDTO;
import com.forcen.edaara.model.Cours;

import java.util.List;

public interface CoursService {
    CoursResponseDTO ajouterCours(CoursRequestDTO coursRequestDTO);
    List<CoursResponseDTO> obtenirTousLesCours();
    CoursResponseDTO obtenirCoursParId(Long idCours);
    void supprimerCours(Long idCours);
    CoursResponseDTO modifierCours(Long idCours, CoursRequestDTO coursRequestDTO);
    Cours findCoursById(Long idCours);
}
