package com.hernandezsanchez.dev.helio.tareas.infrastructure.database.mapper;

import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.entity.TareaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TareaEntityMapper {

    @Mapping(target = "subTareaEntities", ignore = true)
    TareaEntity mapToTareaEntity(Tarea tarea);

    @Mapping(target = "subTareas", ignore = true)
    Tarea mapToTarea(TareaEntity tareaEntity);
}
