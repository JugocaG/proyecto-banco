package com.unisabana.proyectobanco.controller.dto;

import com.unisabana.proyectobanco.vo.TipoTransaccionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransaccionDTO {

    private int cuentaOrigen;

    private int cuentaDestino;

    private TipoTransaccionEnum tipoTransaccion;

    private int valor;


}
