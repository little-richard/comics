package com.zup.assessment.infra.rest.client.dto;

import lombok.Data;

import java.util.List;

@Data
public class EventsListDTO {

    private Integer available;

    private String collectionURI;

    private List<SummaryDTO> items;

    private Integer returned;

}
