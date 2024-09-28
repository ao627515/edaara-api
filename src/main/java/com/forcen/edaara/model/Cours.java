package com.forcen.edaara.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cours {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idCours;

  private String nomCours;
  private String description;

  @ManyToOne
  @JoinColumn(
      name = "id_formateur",
      referencedColumnName =
          "idUtilisateur") // Vérifiez que 'idUtilisateur' est bien la clé primaire dans 'Formateur'
  private Formateur formateur;

  @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
  private List<Module> modules;

  @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
  private List<Ressource> ressources;
}
