package com.unisabana.proyectobanco.controller.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter

public class TransaccionDTO {
    private int id_transaccion;

    private int cuenta_origen;

    private int cuenta_destino;

    private int valor;
}
