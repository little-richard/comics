package com.zup.assessment.infra.rest.client.dto;

import lombok.Data;

@Data
public class SummaryWithTypeDTO {

    private String resourceURI;

    private String name;

    private String type;

}
