package com.zup.assessment.infra.rest.client.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreatorListDTO {

    private Integer available;

    private String collectionURI;

    private List<SummaryWithRoleDTO> items;

    private Integer returned;

}
