package com.zup.assessment.infra.rest.client.dto;

import lombok.Data;

import java.util.List;

@Data
public class StorieListDTO {

    private Integer available;

    private String collectionURI;

    private List<SummaryWithTypeDTO> items;

    private Integer returned;

}
