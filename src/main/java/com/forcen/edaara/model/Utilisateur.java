package com.forcen.edaara.model;

import com.forcen.edaara.enums.Role;
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
        @Enumerated(EnumType.STRING)
        private Role role;

        @OneToMany(mappedBy = "utilisateur")
        private List<MessagePrive> messagesPrives;

    }


