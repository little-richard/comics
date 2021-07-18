package com.zup.assessment.application.service;

import com.sun.istack.NotNull;
import com.zup.assessment.domain.exception.CPFException;
import com.zup.assessment.domain.exception.UsuarioException;
import com.zup.assessment.domain.model.Comic;
import com.zup.assessment.domain.model.Usuario;
import com.zup.assessment.domain.repository.UsuarioRepository;
import com.zup.assessment.domain.service.UsuarioService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(@Lazy @NotNull UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;

    }

    @Override
    public Usuario cadastrar(Usuario usuario) throws UsuarioException, CPFException {

        return this.usuarioRepository.salvar(usuario);

    }

    @Override
    public Usuario consultarPorId(Long id) throws UsuarioException, CPFException {

        return this.usuarioRepository.consultarPorId(id);

    }

    @Override
    public Usuario cadastrarComic(Usuario usuario, Comic comic) throws UsuarioException, CPFException {

        usuario.adicionarComic(comic);

        this.usuarioRepository.salvar(usuario);

        return usuario;
    }

}
