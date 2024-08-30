package org.sid.salesmanagement.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class LivraisonDTO {
    private Long id;
    private Date date;
    private String description;
}
