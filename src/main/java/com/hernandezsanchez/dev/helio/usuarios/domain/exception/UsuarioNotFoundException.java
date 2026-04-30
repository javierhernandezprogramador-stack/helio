package com.hernandezsanchez.dev.helio.usuarios.domain.exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(Long id) {
        super("El usuario con el id: " + id + " no funciona");
    }
}
