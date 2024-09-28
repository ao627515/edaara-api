package com.forcen.edaara.service;


import com.forcen.edaara.dto.FormateurRequestDTO;
import com.forcen.edaara.dto.response.FormateurResponseDTO;


public interface FormateurService {
    FormateurResponseDTO ajouterFormateur(FormateurRequestDTO formateurRequestDTO);
}
