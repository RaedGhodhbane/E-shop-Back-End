package org.sid.salesmanagement.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class FactureDTO {
    private Date date;
    private Float baseHT;
    private Float tva;
    private Float remise;
    private Float totalHT;
    private Float totalTTC;
}
