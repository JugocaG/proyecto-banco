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

    public CuentaDTO(int id, CuentaEnum tipoCuenta, NivelEnum nivel, int idPropietario) {
        this.id = id;
        this.tipoCuenta = tipoCuenta;
        this.nivel = nivel;
        this.idPropietario = idPropietario;
    }
}
