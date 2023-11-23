package com.unisabana.proyectobanco.bd;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table( name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia_cliente")
    @SequenceGenerator(name = "secuencia_cliente", sequenceName = "secuencia_cliente", allocationSize = 1, initialValue = 1000)
    private int id;

    private String nombre;

    private int numeroCuentasCorriente;

    private int numeroCuentasAhorro;

    private int numeroTarjetasCredito;

}
