package com.zup.assessment.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UsuarioExceptionTest {

    @Test
    void quandoInstanciaException_deveRetornarExceptionComSucesso() {

        //GIVEN
        String mensagem = "Mensagem de erro";

        //WHEN
        UsuarioException usuarioException = new UsuarioException(mensagem);

        //THEN
        assertNotNull(usuarioException);
        assertEquals(mensagem, usuarioException.getMessage());

    }

}
