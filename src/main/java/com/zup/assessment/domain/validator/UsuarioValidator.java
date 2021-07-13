package com.zup.assessment.domain.validator;

import com.zup.assessment.domain.exception.UsuarioException;
import com.zup.assessment.domain.model.Usuario;
import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

public class UsuarioValidator {

    public static final String MENSAGEM_ERRO_CAMPOS_OBRIGATORIOS = "Usuário inválido: algum campo está vazio";

    public static void validar(Usuario usuario) throws UsuarioException {

        validarCamposObrigatorios(usuario);

    }

    private static void validarCamposObrigatorios(Usuario usuario) throws UsuarioException {

        boolean nomeVazio = Strings.isBlank(usuario.getNome());
        boolean emailVazio = Strings.isBlank(usuario.getEmail());
        boolean dataNascimentoVazia = Objects.isNull(usuario.getDataNascimento());
        boolean cpfVazio = Objects.isNull(usuario.getCpf());

        if(nomeVazio || emailVazio || dataNascimentoVazia || cpfVazio)
            throw new UsuarioException(MENSAGEM_ERRO_CAMPOS_OBRIGATORIOS);
    }

}
