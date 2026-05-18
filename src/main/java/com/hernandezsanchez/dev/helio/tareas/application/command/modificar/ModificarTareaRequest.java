package com.hernandezsanchez.dev.helio.tareas.application.command.modificar;

import com.hernandezsanchez.dev.helio.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ModificarTareaRequest implements Request<ModificarTareaResponse> {
    private Long id;
    private String nombre;
    private String descripcion;
    private int prioridad;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private int estado;
}
