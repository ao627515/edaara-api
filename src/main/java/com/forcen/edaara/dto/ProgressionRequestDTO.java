package com.forcen.edaara.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgressionRequestDTO {
  private Long id_etudiant;
  private Long id_cours;
  private int pourcentage;
}
