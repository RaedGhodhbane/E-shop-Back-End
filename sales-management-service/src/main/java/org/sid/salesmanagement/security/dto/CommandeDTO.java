package org.sid.salesmanagement.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.salesmanagement.entities.EtatCmd;
import org.sid.salesmanagement.entities.Facture;
import org.sid.salesmanagement.model.Utilisateur;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class CommandeDTO {
    private Date date;
    private String description;
    private EtatCmd etatcmd;
    private Facture facture;
    private Utilisateur utilisateur;
}
