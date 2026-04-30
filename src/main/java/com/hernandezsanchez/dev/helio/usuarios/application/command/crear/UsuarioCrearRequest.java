package com.hernandezsanchez.dev.helio.usuarios.application.command.crear;

import com.hernandezsanchez.dev.helio.common.application.mediator.Request;

public class UsuarioCrearRequest implements Request<UsuarioCrearResponse> {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String token;
    private String confirmado;
}
