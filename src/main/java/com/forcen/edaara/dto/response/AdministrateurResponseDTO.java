package com.forcen.edaara.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdministrateurResponseDTO {
    private Long idUtilisateur;
    private String nom;
    private String prenom;
    private String email;
    private String password;
}
