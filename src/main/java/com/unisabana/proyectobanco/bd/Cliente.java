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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;

    private int numeroCuentasCorriente;

    private int numeroCuentasAhorro;

    private int numeroTarjetasCredito;

}
