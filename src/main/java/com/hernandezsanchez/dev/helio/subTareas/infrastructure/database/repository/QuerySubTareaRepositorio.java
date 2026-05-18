package com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.repository;

import com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.entity.SubTareaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuerySubTareaRepositorio extends JpaRepository<SubTareaEntity, Long> {
    Page<SubTareaEntity> findAll(Specification<SubTareaEntity> specification, Pageable pageable);
}
