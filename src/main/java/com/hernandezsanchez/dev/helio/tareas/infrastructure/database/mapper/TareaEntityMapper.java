package com.hernandezsanchez.dev.helio.tareas.infrastructure.database.mapper;

import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.entity.TareaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TareaEntityMapper {

    TareaEntity mapToTareaEntity(Tarea tarea);

    Tarea mapToTarea(TareaEntity tareaEntity);
}
