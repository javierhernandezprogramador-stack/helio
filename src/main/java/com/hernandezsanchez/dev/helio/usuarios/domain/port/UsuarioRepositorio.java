package com.hernandezsanchez.dev.helio.usuarios.domain.port;

import com.hernandezsanchez.dev.helio.usuarios.domain.entity.Usuario;

public interface UsuarioRepositorio {

    Usuario upsert(Usuario usuario);
}
