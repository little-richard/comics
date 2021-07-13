package com.zup.assessment.infra.rest.client.dto;

import lombok.Data;

import java.util.List;

@Data
public class ComicResponseDTO {

    private Integer id;

    private Integer digitalId;

    private String title;

    private Integer issueNumber;

    private String variantDescription;

    private String description;

    private String modified;

    private String isbn;

    private String upc;

    private String diamondCode;

    private String ean;

    private String issn;

    private String format;

    private String pageCount;

    private List<TextObjectDTO> textObjectDTOS;

    private String resourceURI;

    private List<UrlDTO> urls;

    private SummaryDTO series;

    private List<SummaryDTO> variants;

    private List<SummaryDTO> collections;

    private List<SummaryDTO> collectedIssues;

    private List<ComicPriceDTO> prices;

    private ImageDTO thumbnail;

    private List<ImageDTO> images;

    private CreatorListDTO creators;


}
