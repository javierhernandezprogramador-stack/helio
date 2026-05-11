package com.hernandezsanchez.dev.helio.subTareas.domain.exception;

public class SubTareaNotFoundException extends RuntimeException {
    public SubTareaNotFoundException(Long id) {
        super("La subTarea con el id: " + id + " fallo");
    }
}
