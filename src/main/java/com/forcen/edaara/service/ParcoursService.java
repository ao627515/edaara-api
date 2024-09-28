package com.forcen.edaara.service;

import com.forcen.edaara.dto.ParcoursRequestDTO;
import com.forcen.edaara.dto.response.EtudiantResponseDTO;
import com.forcen.edaara.dto.response.ParcourResponseDTO;
import com.forcen.edaara.model.Parcours;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ParcoursService {
    ParcourResponseDTO creerParcours(ParcoursRequestDTO parcoursRequestDTO);
    List<ParcourResponseDTO> listeParcours();
    ParcourResponseDTO modifierParcours(Long id, ParcoursRequestDTO parcoursRequestDTO);
    void supprimerParcours(Long id);
    ParcourResponseDTO obtenirParcoursParId(Long id);
    List<EtudiantResponseDTO> obtenirToutLesEtudiantDuParcours(Long id);
    Parcours obtenirUnParcoursParSonId(Long id);

}
