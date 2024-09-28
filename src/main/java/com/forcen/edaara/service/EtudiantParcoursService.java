package com.forcen.edaara.service;

import com.forcen.edaara.dto.response.EtudiantResponseDTO;

public interface EtudiantParcoursService {
    EtudiantResponseDTO enregistrerEtudiantDansUnParcours(Long etudiantId, Long parcoursId);
}
