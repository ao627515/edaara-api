package com.forcen.edaara.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Parcours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParcours;

    private String nomParcours;

    @OneToMany(mappedBy = "parcours")
    private List<Etudiant> etudiants;

}

