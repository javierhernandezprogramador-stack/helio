package com.hernandezsanchez.dev.helio.tareas.infrastructure.api.mapper;

import com.hernandezsanchez.dev.helio.tareas.application.command.crear.CrearTareaRequest;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto.CrearTareaDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TareaMapper {

    CrearTareaRequest mapToCrearTareaRequest(CrearTareaDto crearTareaDto);
}
