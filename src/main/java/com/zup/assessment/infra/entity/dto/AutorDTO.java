package com.zup.assessment.infra.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AutorDTO implements Serializable {

    private String nome;

    private String cargo;

}
