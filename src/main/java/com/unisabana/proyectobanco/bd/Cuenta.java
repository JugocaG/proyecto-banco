package com.unisabana.proyectobanco.bd;

import com.unisabana.proyectobanco.CuentaEnum;
import com.unisabana.proyectobanco.NivelEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table (name = "cuenta")
public class Cuenta {
    @Id
    @Column
    private int numero_cuenta;

    @Column
    private CuentaEnum tipo_cuenta;

    @Column
    private NivelEnum nivel;

    @Column
    private int id_propietario;

    @Column
    private int saldo;

}
