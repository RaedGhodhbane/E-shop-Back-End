package org.sid.salesmanagement.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.salesmanagement.entities.Commande;

import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class FactureDTO {
    private Date date;
    private Float baseHT;
    private Float tva;
    private Float remise;
    private Float totalHT;
    private Float totalTTC;
    private List<Commande> commandes;
}
