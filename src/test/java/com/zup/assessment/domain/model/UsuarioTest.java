package com.zup.assessment.domain.model;

import com.zup.assessment.domain.exception.CPFException;
import com.zup.assessment.domain.exception.UsuarioException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void quandoInstanciarUmUsuario_deveRetornarObjetoInstanciado() throws CPFException, UsuarioException {

        //GIVEN
        String nome = "Juan";
        CPF cpf = new CPF("02404626108");
        String email = "email@email.com";
        LocalDate dataNascimento = LocalDate.now();
        Long id = 1l;

        //WHEN
        Usuario usuario = new Usuario.UsuarioBuilder()
                .id(id)
                .nome(nome)
                .cpf(cpf)
                .email(email)
                .dataNascimento(dataNascimento)
                .build();

        //THEN
        assertNotNull(usuario);
        assertEquals(id, usuario.getId());
        assertEquals(nome, usuario.getNome());
        assertEquals(cpf, usuario.getCpf());
        assertEquals(email, usuario.getEmail());
        assertEquals(dataNascimento, usuario.getDataNascimento());

    }

    @Test
    void quandoInstanciarUmUsuarioComDadosInvalidos_deveRetornarException() throws CPFException {

        //GIVEN
        String nome = null;
        CPF cpf = new CPF("02404626108");
        String email = "email@email.com";
        LocalDate dataNascimento = LocalDate.now();
        Long id = 1l;

        //WHEN
        UsuarioException usuarioException = assertThrows(UsuarioException.class, ()-> new Usuario.UsuarioBuilder()
                .id(id)
                .nome(nome)
                .cpf(cpf)
                .email(email)
                .dataNascimento(dataNascimento)
                .build());


        //THEN
        assertNotNull(usuarioException);

    }

}
