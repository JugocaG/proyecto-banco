package com.unisabana.proyectobanco.controller.dto;

import com.unisabana.proyectobanco.CuentaEnum;
import com.unisabana.proyectobanco.NivelEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuentaDTO {
    private int numero_cuenta;

    private CuentaEnum tipo_cuenta;

    private NivelEnum nivel;

    private int id_propietario;

}
