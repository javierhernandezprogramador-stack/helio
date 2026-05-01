package com.hernandezsanchez.dev.helio.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PaginacionResultado<T> {

    private List<T> contenido;
    private int pagina;
    private int cantidad;
    private int totalPaginas;
    private Long totalElementos;
}
