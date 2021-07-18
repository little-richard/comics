package com.zup.assessment.infra.repository;

import com.sun.istack.NotNull;
import com.zup.assessment.domain.exception.CPFException;
import com.zup.assessment.domain.exception.UsuarioException;
import com.zup.assessment.domain.model.Usuario;
import com.zup.assessment.domain.repository.UsuarioRepository;
import com.zup.assessment.infra.entity.UsuarioEntity;
import com.zup.assessment.infra.entity.mapper.UsuarioMapper;
import org.springframework.context.annotation.Lazy;

import java.util.Optional;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioRepositoryImpl(@NotNull @Lazy UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }

    @Override
    public Usuario consultarPorId(Long id) throws UsuarioException, CPFException {

        Optional<UsuarioEntity> entidade = this.usuarioJpaRepository.findById(id);

        return UsuarioMapper.mapToUsuarioDomainFromEntity(entidade.get());

    }

    @Override
    public Usuario salvar(Usuario usuario) throws UsuarioException, CPFException {

        UsuarioEntity usuarioEntity = UsuarioMapper.mapToUsuarioEntityFromDomain(usuario);

        usuarioEntity = usuarioJpaRepository.save(usuarioEntity);

        return UsuarioMapper.mapToUsuarioDomainFromEntity(usuarioEntity);

    }

}
