package com.hernandezsanchez.dev.helio.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PaginacionQuery {
    private int pagina;
    private int cantidad;
    private String ordenarPor;
    private String direccion;
}
