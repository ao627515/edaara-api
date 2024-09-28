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
public abstract class Utilisateur {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idUtilisateur;
        private String nom;
        private String prenom;
        private String email;
        private String password;

        @OneToMany(mappedBy = "utilisateur")
        private List<MessagePrive> messagesPrives;

    }


