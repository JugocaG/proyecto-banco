package com.unisabana.proyectobanco.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TransaccionDTO {

    private int cuentaOrigen;

    private int cuentaDestino;

    private int valor;

    public TransaccionDTO(int cuentaOrigen, int cuentaDestino, int valor) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.valor = valor;
    }
}
