package com.unisabana.proyectobanco.controller.dto;

import com.unisabana.proyectobanco.vo.CuentaEnum;
import com.unisabana.proyectobanco.vo.NivelEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CuentaDTO {

    private int id;
    private CuentaEnum tipoCuenta;

    private NivelEnum nivel;

    private int idPropietario;



}
