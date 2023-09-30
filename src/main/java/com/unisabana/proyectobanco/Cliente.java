package com.unisabana.proyectobanco;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table( name = "Cliente")
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
