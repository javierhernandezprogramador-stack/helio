package com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.mapper;

import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.entity.SubTareaEntity;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.mapper.TareaEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {TareaEntityMapper.class}
)
public interface SubTareaEntityMapper {

    @Mapping(source = "tarea", target = "tareaEntity")
    SubTareaEntity mapToSubTareaEntity(SubTarea subTarea);

    @Mapping(source = "tareaEntity", target = "tarea")
    SubTarea mapToSubTarea(SubTareaEntity subTareaEntity);
}
