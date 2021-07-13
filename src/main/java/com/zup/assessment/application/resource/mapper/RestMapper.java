package com.zup.assessment.application.resource.mapper;

import com.zup.assessment.application.resource.dto.UsuarioDTO;
import com.zup.assessment.domain.model.Comic;
import com.zup.assessment.domain.model.Usuario;
import com.zup.assessment.infra.entity.dto.AutorDTO;
import com.zup.assessment.infra.entity.dto.ComicDTO;
import com.zup.assessment.infra.entity.mapper.UsuarioMapper;

import java.util.List;
import java.util.stream.Collectors;

public class RestMapper {

    public static UsuarioDTO convertToUsuarioDTOFromUsuario(Usuario usuario) {

        List<ComicDTO> comicDTOList = usuario.getComics()
                .stream()
                .map(RestMapper::mapToComicDTOFromDomain)
                .collect(Collectors.toList());

        return UsuarioDTO.builder()
                .id(usuario.getId())
                .cpf(usuario.getCpf().getNumero())
                .nome(usuario.getNome())
                .dataNascimento(usuario.getDataNascimento().toString())
                .email(usuario.getEmail())
                .comics(comicDTOList)
                .build();

    }

    public static ComicDTO mapToComicDTOFromDomain(Comic comic) {

        List<AutorDTO> listaAutores = comic.getAutores()
                .stream()
                .map(UsuarioMapper::mapToAutorDTOFromDomain)
                .collect(Collectors.toList());

        return ComicDTO.builder()
                .id(comic.getId())
                .descricao(comic.getDescricao())
                .isbn(comic.getIsbn())
                .titulo(comic.getTitulo())
                .preco(comic.getPrecoComDesconto())
                .autores(listaAutores)
                .build();

    }

}
