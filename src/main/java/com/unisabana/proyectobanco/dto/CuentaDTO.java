package com.unisabana.proyectobanco.dto;

import com.unisabana.proyectobanco.vo.CuentaEnum;
import com.unisabana.proyectobanco.vo.NivelEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CuentaDTO {

    private int id;
    private CuentaEnum tipoCuenta;

    private NivelEnum nivel;

    private int idPropietario;



}
