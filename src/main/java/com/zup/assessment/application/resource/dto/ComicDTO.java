package com.zup.assessment.application.resource.dto;

import com.zup.assessment.infra.entity.dto.AutorDTO;
import lombok.Builder;
import lombok.Data;

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

    private boolean descontoAtivo;

    private String diaDesconto;

}
