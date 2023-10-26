package com.unisabana.proyectobanco.bd;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@Entity

@Table(name = "transaccion")
public class Transaccion {

    @Id
    @Column
    private int id_transaccion;

    @Column
    private int cuenta_origen;

    @Column
    private int cuenta_destino;

    @Column
    private int valor;

    @Column
    private LocalDateTime fecha;
}
