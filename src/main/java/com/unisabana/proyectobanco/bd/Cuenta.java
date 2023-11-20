package com.unisabana.proyectobanco.bd;

import com.unisabana.proyectobanco.vo.CuentaEnum;
import com.unisabana.proyectobanco.vo.NivelEnum;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table (name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia_cuenta")
    @SequenceGenerator(name = "secuencia_cuenta", sequenceName = "secuencia_cuenta", allocationSize = 1, initialValue = 1000)
    private int numeroCuenta;

    private CuentaEnum tipoCuenta;

    private NivelEnum nivel;

    private int idPropietario;

    private int saldo;

}
