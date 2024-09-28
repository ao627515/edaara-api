package com.forcen.edaara.dto.response;

import com.forcen.edaara.model.Cours;
import com.forcen.edaara.model.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgressionResponseDTO {
  //    Long id_etudiant;
  //    Long id_cours;
  private Long idProgression;
  private int pourcentage;
  private Long etudiant_id;
  private Long cours_id;
}
