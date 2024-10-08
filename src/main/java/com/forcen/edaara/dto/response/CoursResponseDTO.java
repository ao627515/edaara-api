package com.forcen.edaara.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoursResponseDTO {
    private Long idCours;
    private String nomCours;
    private String description;
    private String idFormateur;
}
