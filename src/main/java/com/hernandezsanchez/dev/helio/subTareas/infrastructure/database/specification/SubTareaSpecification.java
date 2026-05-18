package com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.specification;

import com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.entity.SubTareaEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public class SubTareaSpecification {

    public static Specification<SubTareaEntity> byTarea(Long idTarea) {
        return (root, query, criteriaBuilder) -> {

            //System.out.println("Consulta de tarea");
            //System.out.println("De la entidad: " + root.get("tareaEntity").get("id"));
            //System.out.println("Dato que le mando: " + idTarea);

            return idTarea == null ? null : criteriaBuilder.equal(root.get("tareaEntity").get("id"), idTarea);
        };
    }
}
