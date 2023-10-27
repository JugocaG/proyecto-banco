package com.unisabana.proyectobanco.bd;

import com.unisabana.proyectobanco.CuentaEnum;
import com.unisabana.proyectobanco.NivelEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table (name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numeroCuenta;

    private CuentaEnum tipoCuenta;

    private NivelEnum nivel;

    private int idPropietario;

    private int saldo;

}
