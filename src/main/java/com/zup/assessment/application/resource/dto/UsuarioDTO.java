package com.zup.assessment.application.resource.dto;

import com.zup.assessment.infra.entity.dto.ComicDTO;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String dataNascimento;

    private List<ComicDTO> comics;
}
