package com.zup.assessment.domain.model;

import com.zup.assessment.domain.exception.UsuarioException;
import com.zup.assessment.domain.validator.UsuarioValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter(AccessLevel.PRIVATE)
public class Usuario {

    private Long id;

    private String nome;

    private CPF cpf;

    private String email;

    private LocalDate dataNascimento;

    private List<Comic> comics;

    private Usuario() {

    }

    public static class UsuarioBuilder {

        private Long id;

        private String nome;

        private CPF cpf;

        private String email;

        private LocalDate dataNascimento;

        private List<Comic> comics;

        public UsuarioBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UsuarioBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public UsuarioBuilder cpf(CPF cpf){
            this.cpf = cpf;
            return this;
        }

        public UsuarioBuilder email(String email){
            this.email = email;
            return this;
        }

        public UsuarioBuilder dataNascimento(LocalDate dataNascimento){
            this.dataNascimento = dataNascimento;
            return this;
        }

        public UsuarioBuilder comics(List<Comic> comics){
            this.comics = comics;
            return this;
        }

        public Usuario build() throws UsuarioException {

            Usuario usuario = new Usuario();
            usuario.setId(this.id);
            usuario.setCpf(this.cpf);
            usuario.setNome(this.nome);
            usuario.setEmail(this.email);
            usuario.setDataNascimento(this.dataNascimento);
            usuario.setComics(Objects.isNull(this.comics) ? Collections.emptyList() : this.comics);
            UsuarioValidator.validar(usuario);

            return usuario;
        }

    }

    public void adicionarComic(Comic comic) {

        if(Objects.nonNull(comics))
            this.comics.add(comic);

    }

}
