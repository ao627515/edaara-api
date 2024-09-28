package com.forcen.edaara.controller;

import com.forcen.edaara.dto.CoursRequestDTO;
import com.forcen.edaara.dto.response.CoursResponseDTO;
import com.forcen.edaara.service.CoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cours") // Ce chemin sera utilisé pour toutes les routes de cette classe.
@RequiredArgsConstructor // Lombok injecte automatiquement les dépendances final, notamment le service CoursService.
public class CoursController {

    // Dépendance du service qui gère la logique métier pour les opérations sur les cours.
    @Autowired
    private final CoursService coursService;

    /**
     * Méthode pour ajouter un cours.
     * Elle reçoit les données du cours via un DTO dans le corps de la requête et renvoie un objet CoursResponseDTO.
     *
     * @param coursRequestDTO contient les informations nécessaires pour créer un cours (nom, description, formateur).
     * @return une réponse HTTP avec le DTO du cours créé et le statut HTTP 201 (CREATED).
     */
    @PostMapping
    public ResponseEntity<CoursResponseDTO> ajouterCours(@RequestBody CoursRequestDTO coursRequestDTO) {
        CoursResponseDTO responseDTO = coursService.ajouterCours(coursRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED); // Retourne le cours ajouté avec un statut 201.
    }

    /**
     * Méthode pour obtenir la liste de tous les cours disponibles.
     *
     * @return une réponse HTTP avec la liste des cours (List<CoursResponseDTO>) et le statut HTTP 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<CoursResponseDTO>> obtenirTousLesCours() {
        List<CoursResponseDTO> coursList = coursService.obtenirTousLesCours();
        return new ResponseEntity<>(coursList, HttpStatus.OK); // Retourne la liste des cours avec un statut 200.
    }

    /**
     * Méthode pour obtenir un cours par son identifiant (ID).
     *
     * @param idCours l'identifiant du cours que l'on souhaite obtenir.
     * @return une réponse HTTP avec les détails du cours (CoursResponseDTO) et le statut HTTP 200 (OK).
     */
    @GetMapping("/{id}")
    public ResponseEntity<CoursResponseDTO> obtenirCoursParId(@PathVariable Long idCours) {
        CoursResponseDTO responseDTO = coursService.obtenirCoursParId(idCours);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK); // Retourne le cours demandé avec un statut 200.
    }

    /**
     * Méthode pour modifier un cours existant.
     *
     * @param idCours l'identifiant du cours à modifier.
     * @param coursRequestDTO contient les nouvelles informations pour le cours.
     * @return une réponse HTTP avec les informations mises à jour du cours et le statut HTTP 200 (OK).
     */
    @PutMapping("/{id}")
    public ResponseEntity<CoursResponseDTO> modifierCours(@PathVariable Long idCours, @RequestBody CoursRequestDTO coursRequestDTO) {
        CoursResponseDTO responseDTO = coursService.modifierCours(idCours, coursRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK); // Retourne le cours mis à jour avec un statut 200.
    }

    /**
     * Méthode pour supprimer un cours par son identifiant (ID).
     *
     * @param idCours l'identifiant du cours à supprimer.
     * @return une réponse HTTP sans contenu avec le statut HTTP 204 (NO CONTENT) pour indiquer la suppression réussie.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCours(@PathVariable Long idCours) {
        coursService.supprimerCours(idCours);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Indique que le cours a été supprimé avec succès (204).
    }
}
