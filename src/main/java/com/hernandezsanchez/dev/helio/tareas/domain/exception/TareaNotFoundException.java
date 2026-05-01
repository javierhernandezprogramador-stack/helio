package com.hernandezsanchez.dev.helio.tareas.domain.exception;

public class TareaNotFoundException extends RuntimeException {
    public TareaNotFoundException(Long id) {
        super("Error en la tarea con id: " + id);
    }
}
