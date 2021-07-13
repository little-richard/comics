package com.zup.assessment.infra.entity.mapper;

import com.zup.assessment.domain.exception.AutorException;
import com.zup.assessment.domain.exception.CPFException;
import com.zup.assessment.domain.exception.ComicException;
import com.zup.assessment.domain.exception.UsuarioException;
import com.zup.assessment.domain.model.Autor;
import com.zup.assessment.domain.model.CPF;
import com.zup.assessment.domain.model.Comic;
import com.zup.assessment.domain.model.Usuario;
import com.zup.assessment.infra.entity.UsuarioEntity;
import com.zup.assessment.infra.entity.dto.AutorDTO;
import com.zup.assessment.infra.entity.dto.ComicDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    public static UsuarioEntity mapToUsuarioEntityFromDomain(Usuario usuario) {

        List<ComicDTO> listaComics = usuario.getComics()
                .stream()
                .map(UsuarioMapper::mapToComicDTOFromDomain)
                .collect(Collectors.toList());

        return UsuarioEntity.builder()
                .id(usuario.getId())
                .cpf(usuario.getCpf().getNumero())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .dataNascimento(usuario.getDataNascimento())
                .comics(listaComics)
                .build();

    }

    public static Usuario mapToUsuarioDomainFromEntity(UsuarioEntity usuarioEntity) throws CPFException, UsuarioException {

        List<Comic> listaComics = usuarioEntity.getComics()
                .stream()
                .map(obj-> {
                    try {
                        return mapToDomainFromComicDTO(obj);
                    } catch (ComicException e) {
                        return null;
                    }
                })
                .collect(Collectors.toList());

        return new Usuario.UsuarioBuilder()
                .id(usuarioEntity.getId())
                .cpf(new CPF(usuarioEntity.getCpf()))
                .email(usuarioEntity.getEmail())
                .nome(usuarioEntity.getNome())
                .dataNascimento(usuarioEntity.getDataNascimento())
                .comics(listaComics)
                .build();

    }

    public static Comic mapToDomainFromComicDTO(ComicDTO comicDTO) throws ComicException {

        List<Autor> listaAutores = comicDTO.getAutores()
                .stream()
                .map(obj-> {
                    try {
                        return mapToDomainFromAutorDTO(obj);
                    } catch (AutorException e) {
                        return null;
                    }
                })
                .collect(Collectors.toList());

        return new Comic.ComicBuilder()
                .id(comicDTO.getId())
                .isbn(comicDTO.getIsbn())
                .preco(comicDTO.getPreco())
                .titulo(comicDTO.getTitulo())
                .descricao(comicDTO.getDescricao())
                .autores(listaAutores)
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
                .preco(comic.getPreco())
                .autores(listaAutores)
                .build();

    }

    public static AutorDTO mapToAutorDTOFromDomain(Autor autor) {

        return AutorDTO.builder()
                .nome(autor.getNome())
                .cargo(autor.getCargo())
                .build();

    }

    public static Autor mapToDomainFromAutorDTO(AutorDTO autorDTO) throws AutorException {

        return new Autor.Builder()
                .nome(autorDTO.getNome())
                .cargo(autorDTO.getCargo())
                .build();

    }

}
