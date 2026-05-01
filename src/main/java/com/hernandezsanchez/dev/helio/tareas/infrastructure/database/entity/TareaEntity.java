package com.hernandezsanchez.dev.helio.tareas.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tareas")
@Data

public class TareaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int estado;
}
