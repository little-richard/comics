package com.zup.assessment.domain.model;

import com.zup.assessment.domain.exception.CPFException;
import com.zup.assessment.domain.validator.CPFValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CPFTest {

    @Test
    void quandoInstanciarCPF_deveRetornarNumeroComSucesso() throws CPFException {

        //GIVEN
        String numero = "02404626199";

        //WHEN
        CPF cpf = new CPF(numero);

        //THEN
        assertNotNull(cpf);
        assertEquals(numero, cpf.getNumero());

    }

    @Test
    void quandoInstanciaCPFComFormatacaoInvalida_deveRetornarException() {

        //GIVEN
        String numero = "02404626199555";

        //WHEN
        CPFException cpfException = assertThrows(CPFException.class, () -> new CPF(numero));

        //THEN
        assertNotNull(cpfException);
        assertEquals(CPFValidator.MENSAGEM_CPF_FORMATACAO_INVALIDA, cpfException.getMessage());

    }

    @Test
    void quandoInstanciaCPFComNumeroVazio_deveRetornarException() {

        //GIVEN
        String numero = null;

        //WHEN
        CPFException cpfException = assertThrows(CPFException.class, () -> new CPF(numero));

        //THEN
        assertNotNull(cpfException);
        assertEquals(CPFValidator.MENSAGEM_CPF_VAZIO, cpfException.getMessage());

    }

}
