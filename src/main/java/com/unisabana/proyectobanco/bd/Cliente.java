package com.unisabana.proyectobanco.bd;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table( name = "cliente")
public class Cliente {
    @Id
    @Column
    private int id;

    @Column
    private String nombre;

    @Column(name = "numero_cuentas_corriente")
    private int numeroCuentasCorriente;


    @Column(name = "numero_cuentas_ahorro")
    private int numeroCuentasAhorro;

    @Column(name = "numero_tarjetas_credito")
    private int numeroTarjetasCredito;

}
