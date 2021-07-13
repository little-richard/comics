package com.zup.assessment.infra.entity.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ComicDTO implements Serializable {

    private Long id;

    private String titulo;

    private String isbn;

    private String descricao;

    private BigDecimal preco;

    private List<AutorDTO> autores;

}
