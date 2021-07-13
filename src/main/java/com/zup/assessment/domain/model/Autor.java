package com.zup.assessment.domain.model;

import com.zup.assessment.domain.exception.AutorException;
import com.zup.assessment.domain.validator.AutorValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class Autor {

    private String nome;

    private String cargo;

    private Autor() {

    }

    public static class Builder {

        private String nome;

        private String cargo;

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder cargo(String cargo) {
            this.cargo = cargo;
            return this;
        }

        public Autor build() throws AutorException {

            Autor autor = new Autor();
            autor.setNome(this.nome);
            autor.setCargo(this.cargo);

            AutorValidator.validar(autor);

            return autor;
        }

    }

}
