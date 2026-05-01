package com.hernandezsanchez.dev.helio.tareas.infrastructure.database.repository;

import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.entity.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryRepository extends JpaRepository<TareaEntity, Long> {
}
