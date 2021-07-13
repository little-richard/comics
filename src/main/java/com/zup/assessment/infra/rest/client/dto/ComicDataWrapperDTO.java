package com.zup.assessment.infra.rest.client.dto;

import lombok.Data;


@Data
public class ComicDataWrapperDTO {

    private Integer code;

    private String status;

    private String copyright;

    private String attributionText;

    private String attributionHTML;
    
    private String etag;

    private ComicDataContainerDTO data;

}
