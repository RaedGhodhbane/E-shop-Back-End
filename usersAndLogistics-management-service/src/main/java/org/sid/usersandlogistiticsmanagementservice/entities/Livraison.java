package org.sid.usersandlogistiticsmanagementservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.usersandlogistiticsmanagementservice.models.Article;
import org.sid.usersandlogistiticsmanagementservice.models.Boutique;

import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String description;
    @OneToMany(mappedBy = "livraison")
    private List<ModelLivraison> modelLivraison;
    @Transient
    private Article article;
    @Transient
    private Boutique boutique;

}
