package com.forcen.edaara.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EvaluationRequestDTO {
    private String sujet;
    private Long etudiant_id;
}
