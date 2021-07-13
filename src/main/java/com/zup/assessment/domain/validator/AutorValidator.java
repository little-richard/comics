package com.zup.assessment.domain.validator;

import com.zup.assessment.domain.exception.AutorException;
import com.zup.assessment.domain.model.Autor;
import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

public class AutorValidator {

    public static String MENSAGEM_ERRO_STRING_VAZIA = "String vazia ou null: %s";
    public static String MENSAGEM_ERRO_OBJETO_NULL = "Erro ao validar Comic, algum campo está = NULL";
    public static String MENSAGEM_ERRO_VALOR_NULL = "Erro ao validar Valor, algum campo está = NULL";

    public static void validar(Autor autor) throws AutorException {

        validarSeObjetoIsNotNull(autor);
        validarSeStringNotEmpty(autor.getNome());
        validarSeStringNotEmpty(autor.getCargo());

    }

    private static void validarSeObjetoIsNotNull(Object obj) throws AutorException {

        boolean objetoNull = Objects.isNull(obj);

        lancarComicException(objetoNull, MENSAGEM_ERRO_OBJETO_NULL);

    }

    private static void validarSeStringNotEmpty(String isbn) throws AutorException {

        boolean isbnVazio = Strings.isBlank(isbn);

        lancarComicException(isbnVazio, String.format(MENSAGEM_ERRO_STRING_VAZIA, "ISBN"));

    }

    private static void lancarComicException(boolean erro, String mensagem) throws AutorException {

        if(erro)
            throw new AutorException(mensagem);

    }

}
