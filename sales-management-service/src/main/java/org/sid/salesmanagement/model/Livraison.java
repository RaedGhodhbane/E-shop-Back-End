package org.sid.salesmanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.sid.salesmanagement.entities.Article;
import org.sid.salesmanagement.entities.Boutique;

import java.util.Date;

@Data
public class Livraison {
    private Long id;
    private Date date;
    private String description;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Article article;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boutique boutique;
}
