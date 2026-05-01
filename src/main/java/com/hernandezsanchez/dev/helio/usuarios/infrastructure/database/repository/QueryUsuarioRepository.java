package com.hernandezsanchez.dev.helio.usuarios.infrastructure.database.repository;

import com.hernandezsanchez.dev.helio.usuarios.infrastructure.database.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
