package org.sid.salesmanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Float baseHT;
    private Float tva;
    private Float remise;
    private Float totalHT;
    private Float totalTTC;
    @OneToMany(mappedBy = "facture")
    private List<Commande> commande;
}
