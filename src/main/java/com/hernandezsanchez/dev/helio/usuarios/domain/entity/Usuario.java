package com.hernandezsanchez.dev.helio.usuarios.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String token;
    private Long confirmado;
}
