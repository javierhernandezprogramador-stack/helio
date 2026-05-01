package com.hernandezsanchez.dev.helio.usuarios.infrastructure.database;

import com.hernandezsanchez.dev.helio.usuarios.domain.entity.Usuario;
import com.hernandezsanchez.dev.helio.usuarios.domain.port.UsuarioRepositorio;
import com.hernandezsanchez.dev.helio.usuarios.infrastructure.database.entity.UsuarioEntity;
import com.hernandezsanchez.dev.helio.usuarios.infrastructure.database.mapper.UsuarioEntityMapper;
import com.hernandezsanchez.dev.helio.usuarios.infrastructure.database.repository.QueryUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UsuarioRepositorioImpl implements UsuarioRepositorio {

    private final UsuarioEntityMapper usuarioEntityMapper;

    private final QueryUsuarioRepository repository;

    @Override
    public Usuario upsert(Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioEntityMapper.mapToUsuarioEntity(usuario);
        UsuarioEntity resultado = repository.save(usuarioEntity);

        return usuarioEntityMapper.mapToUsuario(resultado);
    }
}
