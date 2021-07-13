package com.zup.assessment.domain.validator;

import com.zup.assessment.domain.exception.CPFException;
import com.zup.assessment.domain.model.CPF;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CPFValidatorTest {

    @Test
    void quandoInstanciarCPF_deveRetornarNumeroComSucesso() {

        //GIVEN
        String numero = "02404626199";

        //WHEN
        assertDoesNotThrow(() -> CPFValidator.validar(new CPF(numero)));

    }

    @Test
    void quandoInstanciaCPFComFormatacaoInvalida_deveRetornarException() {

        //GIVEN
        String numero = "02404626199555";

        //WHEN
        CPFException cpfException = assertThrows(CPFException.class, () -> CPFValidator.validar(new CPF(numero)));

        //THEN
        assertNotNull(cpfException);
        assertEquals(CPFValidator.MENSAGEM_CPF_FORMATACAO_INVALIDA, cpfException.getMessage());

    }

    @Test
    void quandoInstanciaCPFComNumeroVazio_deveRetornarException() {

        //GIVEN
        String numero = null;

        //WHEN
        CPFException cpfException = assertThrows(CPFException.class, () -> CPFValidator.validar(new CPF(numero)));

        //THEN
        assertNotNull(cpfException);
        assertEquals(CPFValidator.MENSAGEM_CPF_VAZIO, cpfException.getMessage());

    }

}
