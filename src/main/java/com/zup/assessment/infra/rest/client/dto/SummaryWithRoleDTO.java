package com.zup.assessment.infra.rest.client.dto;

import lombok.Data;

@Data
public class SummaryWithRoleDTO {

    private String resourceURI;

    private String name;

    private String role;

}
