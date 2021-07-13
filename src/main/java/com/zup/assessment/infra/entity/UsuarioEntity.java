package com.zup.assessment.infra.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.zup.assessment.infra.entity.dto.ComicDTO;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Type(type = "jsonb")
    @Column(nullable = false, columnDefinition = "jsonb default '[]'")
    private List<ComicDTO> comics;

}
