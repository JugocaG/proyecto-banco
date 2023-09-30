package com.unisabana.proyectobanco.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private int id;
    private String nombre;

    public ClienteDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;

    }

}
