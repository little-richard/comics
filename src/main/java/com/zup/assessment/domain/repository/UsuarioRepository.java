package com.zup.assessment.domain.repository;

import com.zup.assessment.domain.exception.CPFException;
import com.zup.assessment.domain.exception.UsuarioException;
import com.zup.assessment.domain.model.Usuario;

public interface UsuarioRepository {

    Usuario incluir(Usuario usuario) throws UsuarioException, CPFException;

    Usuario consultarPorId(Long id) throws UsuarioException, CPFException;

    Usuario consultarPorCPF(Long id);

    Usuario salvar(Usuario usuario) throws UsuarioException, CPFException;

}
