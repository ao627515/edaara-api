package com.forcen.edaara.service;

import com.forcen.edaara.dto.FormateurRequestDTO;
import com.forcen.edaara.dto.response.FormateurResponseDTO;

import java.util.List;

public interface FormateurService {

    FormateurResponseDTO ajouterFormateur(FormateurRequestDTO formateurRequestDTO);

    FormateurResponseDTO modifierFormateur(Long id, FormateurRequestDTO formateurRequestDTO);

    void supprimerFormateur(Long id);

    FormateurResponseDTO obtenirFormateurParId(Long id);

    List<FormateurResponseDTO> obtenirTousLesFormateurs();
}
