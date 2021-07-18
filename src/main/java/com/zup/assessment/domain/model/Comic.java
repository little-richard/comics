package com.zup.assessment.domain.model;

import com.zup.assessment.domain.exception.ComicException;
import com.zup.assessment.domain.validator.ComicValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Getter
@Setter(AccessLevel.PRIVATE)
public class Comic {

    private Long id;

    private String titulo;

    private String isbn;

    private String descricao;

    private BigDecimal preco;

    private List<Autor> autores;

    private boolean descontoAtivo;

    private EnumDiaSemana diaDesconto;

    private Comic() {

    }

    public static class ComicBuilder {

        private Long id;

        private String titulo;

        private String isbn;

        private String descricao;

        private BigDecimal preco;

        private List<Autor> autores;

        public ComicBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ComicBuilder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public ComicBuilder isbn(String isbn){
            this.isbn = isbn;
            return this;
        }

        public ComicBuilder descricao(String descricao){
            this.descricao = descricao;
            return this;
        }

        public ComicBuilder preco(BigDecimal preco){
            this.preco = preco;
            return this;
        }

        public ComicBuilder autores(List<Autor> autores){
            this.autores = autores;
            return this;
        }

        public Comic build() throws ComicException {

            Comic comic = new Comic();
            comic.setId(this.id);
            comic.setTitulo(this.titulo);
            comic.setDescricao(this.descricao);
            comic.setIsbn(this.isbn);
            comic.setPreco(this.preco);
            comic.setAutores(Objects.isNull(this.autores) ? Collections.emptyList() : this.autores);

            ComicValidator.validar(comic);

            return comic;
        }

    }

    private void processarRegraDescontoAtivo() {

        this.processarRegraDiaDesconto();

        LocalDate hoje = LocalDate.now();
        DayOfWeek diaSemana = hoje.getDayOfWeek();

        this.descontoAtivo = diaSemana.equals(this.getDiaDesconto().getDayOfWeek());
    }

    private void processarRegraDiaDesconto(){
        String diaSemana = isbn.substring(isbn.length() - 1);

        switch (diaSemana){
            case "0":
            case "1":
                diaDesconto = EnumDiaSemana.SEGUNDA;
                break;
            case "2":
            case "3":
                diaDesconto = EnumDiaSemana.TERCA;
                break;
            case "4":
            case "5":
                diaDesconto = EnumDiaSemana.QUARTA;
                break;
            case "6":
            case "7":
                diaDesconto = EnumDiaSemana.QUINTA;
                break;
            case "8":
            case "9":
                diaDesconto = EnumDiaSemana.DOMINGO;
                break;
        }
    }

    public BigDecimal getPrecoComDesconto(){

        this.processarRegraDiaDesconto();;
        this.processarRegraDescontoAtivo();

        BigDecimal precoComDesconto = this.preco;

        if(this.descontoAtivo) {

            BigDecimal precoDesconto = this.preco.multiply(new BigDecimal("0.1"));
            precoComDesconto = this.preco.subtract(precoDesconto);

        }

        return precoComDesconto;
    }
}
