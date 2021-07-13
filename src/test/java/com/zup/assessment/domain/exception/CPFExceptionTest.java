package com.zup.assessment.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CPFExceptionTest {

    @Test
    void quandoInstanciaException_deveRetornarExceptionComSucesso() {

        //GIVEN
        String mensagem = "Mensagem de erro";

        //WHEN
        CPFException cpfException = new CPFException(mensagem);

        //THEN
        assertNotNull(cpfException);
        assertEquals(mensagem, cpfException.getMessage());

    }

}
