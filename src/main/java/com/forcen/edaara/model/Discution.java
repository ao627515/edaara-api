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
public class Discution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiscution;

    private String sujet;

    @OneToMany
    private List<Reponse> reponses;

    @ManyToOne
    @JoinColumn(name = "forum_id")
    private Forum forum;

}

