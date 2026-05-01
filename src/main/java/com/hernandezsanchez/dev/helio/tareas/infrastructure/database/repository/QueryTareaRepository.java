package com.hernandezsanchez.dev.helio.tareas.infrastructure.database.repository;

import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.entity.TareaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryTareaRepository extends JpaRepository<TareaEntity, Long> {

    Page<TareaEntity> findAll(Pageable pageable);
}
