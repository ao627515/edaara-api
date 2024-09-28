package com.forcen.edaara.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Etudiant extends Utilisateur {

  private String matricule;

  @ManyToOne
  @JoinColumn(name = "parcours_id")
  private Parcours parcours;

  @OneToMany(mappedBy = "etudiant")
  private List<Progression> progressions;

  @OneToMany(mappedBy = "etudiant")
  private List<Evaluation> evaluations;
}
