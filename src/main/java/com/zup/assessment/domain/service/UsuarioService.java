package com.zup.assessment.domain.service;

import com.zup.assessment.domain.exception.CPFException;
import com.zup.assessment.domain.exception.UsuarioException;
import com.zup.assessment.domain.model.Comic;
import com.zup.assessment.domain.model.Usuario;

public interface UsuarioService {

    Usuario cadastrar(Usuario usuario) throws UsuarioException, CPFException;

    Usuario consultarPorId(Long id) throws UsuarioException, CPFException;

    Usuario cadastrarComic(Usuario usuario, Comic comic) throws UsuarioException, CPFException;

}
