package com.unisabana.proyectobanco.controller.dto;
import com.unisabana.proyectobanco.CuentaEnum;
import com.unisabana.proyectobanco.NivelEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuentaDTO {

    private int id;

    private CuentaEnum tipoCuenta;

    private NivelEnum nivel;

    private int idPropietario;

}
