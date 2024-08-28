package org.sid.salesmanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.salesmanagement.models.Livraison;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Boutique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lib;
    private String adresse;
    private String tel;
    private String email;
    private String description;
    @Transient
    private Livraison livraison;

}
