package org.sid.salesmanagement.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.salesmanagement.model.Livraison;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String design;
    private float price;
    private double qteStock;
    private int discountRate;
    private String image;
    private String description;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Marque marque;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Categorie categorie;
    @Transient
    private Livraison livraison;
}
