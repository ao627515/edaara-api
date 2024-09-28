package com.forcen.edaara.service.impl;

import com.forcen.edaara.Exception.EntityNotFoundException;
import com.forcen.edaara.Exception.RequestException;
import com.forcen.edaara.dto.CoursRequestDTO;
import com.forcen.edaara.dto.response.CoursResponseDTO;
import com.forcen.edaara.mapper.CoursMapper;
import com.forcen.edaara.model.Cours;
import com.forcen.edaara.model.Formateur;
import com.forcen.edaara.repository.CoursRepository;
import com.forcen.edaara.repository.FormateurRepository;
import com.forcen.edaara.service.CoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoursServiceImpl implements CoursService {

    // Repositories pour accéder aux données des cours et des formateurs
    private final CoursRepository coursRepository;
    private final FormateurRepository formateurRepository;

    // Mapper pour convertir entre les entités et les DTOs
    private final CoursMapper coursMapper;

    // Messages d'erreur constants
    private static final String FORMATEUR_NOT_FOUND = "Formateur non trouvé";
    private static final String COURS_NOT_FOUND = "Cours non trouvé";

    /**
     * Méthode pour ajouter un nouveau cours.
     *
     * @param coursRequestDTO les données du cours à ajouter.
     * @return un DTO représentant le cours ajouté.
     */
    @Override
    public CoursResponseDTO ajouterCours(CoursRequestDTO coursRequestDTO) {
        // Convertir le DTO en entité
        Cours cours = coursMapper.toEntity(coursRequestDTO);

        // Trouver le formateur associé au cours
        Formateur formateur = formateurRepository.findById(coursRequestDTO.getIdFormateur())
                .orElseThrow(() -> new RequestException(FORMATEUR_NOT_FOUND, HttpStatus.NOT_FOUND));

        // Assigner le formateur au cours
        cours.setFormateur(formateur);

        // Sauvegarder le cours dans la base de données
        Cours savedCours = coursRepository.save(cours);

        // Convertir l'entité sauvegardée en DTO et retourner
        return coursMapper.toDto(savedCours);
    }

    /**
     * Méthode pour obtenir tous les cours.
     *
     * @return une liste de DTOs représentant tous les cours.
     */
    @Override
    public List<CoursResponseDTO> obtenirTousLesCours() {
        // Trouver tous les cours dans la base de données
        List<Cours> coursList = coursRepository.findAll();

        // Convertir chaque entité en DTO
        return coursList.stream()
                .map(coursMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour obtenir un cours par son identifiant.
     *
     * @param idCours l'identifiant du cours à obtenir.
     * @return un DTO représentant le cours.
     */
    @Override
    public CoursResponseDTO obtenirCoursParId(Long idCours) {
        // Trouver le cours par ID
        Cours cours = coursRepository.findById(idCours)
                .orElseThrow(() -> new RequestException(COURS_NOT_FOUND, HttpStatus.NOT_FOUND));

        // Convertir l'entité en DTO et retourner
        return coursMapper.toDto(cours);
    }

    /**
     * Méthode pour supprimer un cours par son identifiant.
     *
     * @param idCours l'identifiant du cours à supprimer.
     */
    @Override
    public void supprimerCours(Long idCours) {
        // Supprimer le cours par ID
        coursRepository.deleteById(idCours);
    }

    /**
     * Méthode pour modifier un cours existant.
     *
     * @param idCours l'identifiant du cours à modifier.
     * @param coursRequestDTO les nouvelles données pour le cours.
     * @return un DTO représentant le cours modifié.
     */
    @Override
    public CoursResponseDTO modifierCours(Long idCours, CoursRequestDTO coursRequestDTO) {
        // Trouver le cours existant par ID
        Cours coursExistant = coursRepository.findById(idCours)
                .orElseThrow(() -> new RequestException(COURS_NOT_FOUND, HttpStatus.NOT_FOUND));

        // Trouver le formateur associé au cours
        Formateur formateur = formateurRepository.findById(coursRequestDTO.getIdFormateur())
                .orElseThrow(() -> new RequestException(FORMATEUR_NOT_FOUND, HttpStatus.NOT_FOUND));

        // Mettre à jour les propriétés du cours
        coursExistant.setNomCours(coursRequestDTO.getNomCours());
        coursExistant.setDescription(coursRequestDTO.getDescription());
        coursExistant.setFormateur(formateur);

        // Sauvegarder les modifications dans la base de données
        Cours updatedCours = coursRepository.save(coursExistant);

        // Convertir l'entité mise à jour en DTO et retourner
        return coursMapper.toDto(updatedCours);
    }

    public Cours findCoursById(Long idCours) {
        return coursRepository.findById(idCours)
                .orElseThrow(() -> new EntityNotFoundException("Cours not found"));
    }
}
