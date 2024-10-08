package com.forcen.edaara.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvaluation;
    private String sujet;
    private LocalDate dateEvaluation;
    @ManyToOne
    @JoinColumn(name = "id_etudiant")
    private Etudiant etudiant;

}

