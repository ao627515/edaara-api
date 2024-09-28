package com.forcen.edaara.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) utilisé pour représenter les données nécessaires à la création ou à la mise à jour d'un cours.
 * Utilisé pour transférer les données entre les couches de l'application.
 */
@AllArgsConstructor  // Génère un constructeur avec tous les arguments
@NoArgsConstructor   // Génère un constructeur sans arguments
@Data               // Génère les getters, setters, toString(), equals() et hashCode() automatiquement
public class CoursRequestDTO {

    private String nomCours;        // Nom du cours
    private String description;     // Description du cours
    private Long idFormateur;       // Identifiant du formateur associé au cours (au lieu de l'objet complet)
}
