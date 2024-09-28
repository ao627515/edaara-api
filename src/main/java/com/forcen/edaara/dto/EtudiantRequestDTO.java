package com.forcen.edaara.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EtudiantRequestDTO {
    private String nom;
    private String prenom;
    private String email;
    private String password;
}
