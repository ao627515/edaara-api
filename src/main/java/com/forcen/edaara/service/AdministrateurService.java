package com.forcen.edaara.service;

import com.forcen.edaara.dto.AdministrateurRequestDTO;
import com.forcen.edaara.dto.response.AdministrateurResponseDTO;

import java.util.List;

public interface AdministrateurService {
    AdministrateurResponseDTO ajouterAdministrateur(AdministrateurRequestDTO dto);
    AdministrateurResponseDTO modifierAdministrateur(Long id_administrateur, AdministrateurRequestDTO dto);
    void supprimerAdministrateur(Long id_administrateur);
    List<AdministrateurResponseDTO> obtenirTousLesAdministrateur();
    AdministrateurResponseDTO obtenirAdministrateurParId(Long id_administrateur);
}
