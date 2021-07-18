package com.zup.assessment.domain.repository;

import com.zup.assessment.domain.exception.CPFException;
import com.zup.assessment.domain.exception.UsuarioException;
import com.zup.assessment.domain.model.Usuario;

public interface UsuarioRepository {

    Usuario consultarPorId(Long id) throws UsuarioException, CPFException;

    Usuario salvar(Usuario usuario) throws UsuarioException, CPFException;

}
