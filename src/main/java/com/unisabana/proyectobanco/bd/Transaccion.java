package com.unisabana.proyectobanco.bd;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Setter
@Getter
@Entity

@Table(name = "transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTransaccion;

    private int cuentaOrigen;

    private int cuentaDestino;

    private int valor;

    private LocalDateTime fecha;
}
