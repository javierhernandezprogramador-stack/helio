package com.hernandezsanchez.dev.helio.tareas.infrastructure.api.mapper;

import com.hernandezsanchez.dev.helio.tareas.application.command.crear.CrearTareaRequest;
import com.hernandezsanchez.dev.helio.tareas.application.command.modificar.ModificarTareaRequest;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto.CrearTareaDto;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto.ModificarTareaDto;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto.TareaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TareaMapper {

    CrearTareaRequest mapToCrearTareaRequest(CrearTareaDto crearTareaDto);

    ModificarTareaRequest mapToModificarTareaRequest(ModificarTareaDto modificarTareaDto);

    TareaDto mapToTareaDto(Tarea tarea);

    @Mapping(target = "subTareas", ignore = true)
    Tarea mapToTarea(TareaDto tareaDto);
}
