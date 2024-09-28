package com.forcen.edaara.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Formateur extends Utilisateur {

    private String specialite;

    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    private List<Cours> cours;
}





