package com.zup.assessment.infra.rest.client.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ComicPriceDTO {

    private String type;

    private BigDecimal price;
    
}
