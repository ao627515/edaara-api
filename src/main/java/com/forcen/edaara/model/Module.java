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
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModule;

    private String nomModule;

    @ManyToOne
    @JoinColumn(name = "id_cours")
    private Cours cours;

    @OneToMany(mappedBy = "module")
    private List<Lecon> lecons;

}

