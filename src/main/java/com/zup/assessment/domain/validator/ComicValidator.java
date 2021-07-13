package com.zup.assessment.domain.validator;

import com.zup.assessment.domain.exception.ComicException;
import com.zup.assessment.domain.model.Comic;
import org.apache.logging.log4j.util.Strings;

import java.math.BigDecimal;
import java.util.Objects;

public class ComicValidator {

    public static String MENSAGEM_ERRO_STRING_VAZIA = "String vazia ou null: %s";
    public static String MENSAGEM_ERRO_OBJETO_NULL = "Erro ao validar Comic, algum campo está = NULL";
    public static String MENSAGEM_ERRO_VALOR_NULL = "Erro ao validar Valor, algum campo está = NULL";

    public static void validar(Comic comic) throws ComicException {

        validarSeObjetoIsNotNull(comic);
        validarSeObjetoIsNotNull(comic.getId());
        validarSeStringNotEmpty(comic.getIsbn());
        validarSeStringNotEmpty(comic.getTitulo());
        validarSeNumeroMaiorQueZero(comic.getPreco());

    }

    private static void validarSeNumeroMaiorQueZero(BigDecimal valor) throws ComicException {

        boolean valorInvalido = Objects.isNull(valor) || valor.compareTo(BigDecimal.ZERO) < 1;

        lancarComicException(valorInvalido, MENSAGEM_ERRO_VALOR_NULL);

    }

    private static void validarSeObjetoIsNotNull(Object obj) throws ComicException {

        boolean objetoNull = Objects.isNull(obj);

        lancarComicException(objetoNull, MENSAGEM_ERRO_OBJETO_NULL);

    }

    private static void validarSeStringNotEmpty(String isbn) throws ComicException {

        boolean isbnVazio = Strings.isBlank(isbn);

        lancarComicException(isbnVazio, String.format(MENSAGEM_ERRO_STRING_VAZIA, "ISBN"));

    }

    private static void lancarComicException(boolean erro, String mensagem) throws ComicException {

        if(erro)
            throw new ComicException(mensagem);
    }

}
