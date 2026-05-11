package com.hernandezsanchez.dev.helio.subTareas.application.command.crear;

import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CrearSubTareaResponse {
    private SubTarea subTareaPaginado;
}
