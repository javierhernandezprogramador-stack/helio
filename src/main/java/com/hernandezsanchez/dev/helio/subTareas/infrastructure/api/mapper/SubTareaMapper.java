package com.hernandezsanchez.dev.helio.subTareas.infrastructure.api.mapper;

import com.hernandezsanchez.dev.helio.subTareas.application.command.crear.CrearSubTareaRequest;
import com.hernandezsanchez.dev.helio.subTareas.application.command.modificar.ModificarSubTareaRequest;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.api.dto.CrearSubTareaDto;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.api.dto.ModificarSubTareaDto;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.api.mapper.TareaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {TareaMapper.class}
)
public interface SubTareaMapper {

    CrearSubTareaRequest mapToCrearSubTareaRequest(CrearSubTareaDto crearSubTareaDto);

    ModificarSubTareaRequest mapToModificarSubTareaRequest(ModificarSubTareaDto modificarSubTareaDto);
}
