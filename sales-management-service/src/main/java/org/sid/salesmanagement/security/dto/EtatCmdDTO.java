package org.sid.salesmanagement.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.salesmanagement.entities.Commande;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class EtatCmdDTO {
    private String lib;
    private List<Commande> commandes;
}
