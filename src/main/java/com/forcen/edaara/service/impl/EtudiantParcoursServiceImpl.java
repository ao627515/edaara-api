package com.forcen.edaara.service.impl;

import com.forcen.edaara.dto.response.EtudiantResponseDTO;
import com.forcen.edaara.model.Parcours;
import com.forcen.edaara.service.EtudiantParcoursService;
import com.forcen.edaara.service.EtudiantService;
import com.forcen.edaara.service.ParcoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EtudiantParcoursServiceImpl implements EtudiantParcoursService {

    private final EtudiantService etudiantService;
    private final ParcoursService parcoursService;

    @Override
    public EtudiantResponseDTO enregistrerEtudiantDansUnParcours(Long etudiantId, Long parcoursId) {
        Parcours parcours = parcoursService.obtenirUnParcoursParSonId(parcoursId);
        return etudiantService.enregistrerEtudiantDansUnParcour(etudiantId, parcours);
    }
}
