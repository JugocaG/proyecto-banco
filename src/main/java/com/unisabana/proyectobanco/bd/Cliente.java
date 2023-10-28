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
    @Column
    private int id;

    @Column
    private String nombre;
    @Column
    private int numeroCuentasCorriente;
    @Column
    private int numeroCuentasAhorro;
    @Column
    private int numeroTarjetasCredito;

}
