package com.zup.assessment.domain.validator;

import com.zup.assessment.domain.exception.CPFException;
import com.zup.assessment.domain.model.CPF;
import org.apache.logging.log4j.util.Strings;


public class CPFValidator {

    public static String MENSAGEM_CPF_VAZIO = "CPF Inválido: vazio ou nulo";
    public static String MENSAGEM_CPF_FORMATACAO_INVALIDA = "CPF Inválido: formatacao com erro";

    public static void validar(CPF cpf) throws CPFException {

        validarSeVazioOuNulo(cpf);
        validarFormatacaoCPF(cpf);

    }

    private static void validarSeVazioOuNulo(CPF cpf) throws CPFException {
        boolean cpfVazio = Strings.isBlank(cpf.getNumero());

        if(cpfVazio)
            throw new CPFException(MENSAGEM_CPF_VAZIO);
    }

    private static void validarFormatacaoCPF(CPF cpf) throws CPFException {
        int quantidadeDigitos = cpf.getNumero().length();

        if(quantidadeDigitos != 11)
            throw new CPFException(MENSAGEM_CPF_FORMATACAO_INVALIDA);

    }

}
