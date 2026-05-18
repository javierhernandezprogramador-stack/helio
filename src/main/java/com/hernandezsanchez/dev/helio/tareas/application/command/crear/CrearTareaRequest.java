package com.hernandezsanchez.dev.helio.tareas.application.command.crear;

import com.hernandezsanchez.dev.helio.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class CrearTareaRequest implements Request<CrearTareaResponse> {
    private String nombre;
    private String descripcion;
    private int prioridad;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private int estado;
}
