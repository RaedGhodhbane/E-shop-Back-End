package org.sid.usersandlogistiticsmanagementservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.usersandlogistiticsmanagementservice.models.Commande;

import java.sql.Blob;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mail;
    private String login;
    private String mdp;
    private String sexe;
    private String nom;
    private String prenom;
    private String tel;
    private String image;
    @OneToMany(mappedBy = "utilisateur")
    private List<Adresse> adresse;
    @Transient
    private Commande commande;
}
