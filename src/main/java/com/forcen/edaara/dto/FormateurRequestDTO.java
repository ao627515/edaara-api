package com.forcen.edaara.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FormateurRequestDTO {
    private String nom;
    private String prenom;
    private String specialite;
    private String email;

}
