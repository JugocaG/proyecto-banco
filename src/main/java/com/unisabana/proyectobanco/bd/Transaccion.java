package com.unisabana.proyectobanco.bd;

import com.unisabana.proyectobanco.vo.TipoTransaccionEnum;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Setter
@Getter
@Entity

@Table(name = "transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia_transaccion")
    @SequenceGenerator(name = "secuencia_transaccion", sequenceName = "secuencia_transaccion", allocationSize = 1, initialValue = 1000)
    private int idTransaccion;

    private TipoTransaccionEnum tipoTransaccion;

    private int cuentaOrigen;

    private int cuentaDestino;

    private int valor;

    private LocalDateTime fecha;
}
