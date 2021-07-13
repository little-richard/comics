package com.zup.assessment.infra.rest.client.dto;

import lombok.Data;

import java.util.List;

@Data
public class ComicDataContainerDTO {

    private Integer offset;

    private Integer limit;

    private Integer total;

    private Integer count;

    private List<ComicResponseDTO> results;

}
