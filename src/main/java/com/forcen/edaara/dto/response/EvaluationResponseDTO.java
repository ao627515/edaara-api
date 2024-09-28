package com.forcen.edaara.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EvaluationResponseDTO {
    private Long idEvaluation;
    private String sujet;
    private LocalDate dateEvaluation;
    private Long etudiant_id;
}
