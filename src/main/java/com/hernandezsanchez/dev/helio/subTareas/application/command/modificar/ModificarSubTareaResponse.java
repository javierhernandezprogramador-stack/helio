package com.hernandezsanchez.dev.helio.subTareas.application.command.modificar;

import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ModificarSubTareaResponse {
    private SubTarea subtTareaPaginacion;
}
