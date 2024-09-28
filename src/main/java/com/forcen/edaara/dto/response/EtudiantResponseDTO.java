package com.forcen.edaara.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EtudiantResponseDTO {
    private Long idUtilisateur;
    private String nom;
    private String prenom;
    private String email;
    private Long parcoursId;
    private String matricule;
}
