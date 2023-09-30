package com.unisabana.proyectobanco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO extends Cliente {

    private int id;
    private String nombre;
    private int numeroCuentasCorriente;
    private int numeroCuentasAhorro;
    private int numeroTarjetasCredito;

    public ClienteDTO() {
    }

    public ClienteDTO(int id, String nombre, int numeroCuentasCorriente, int numeroCuentasAhorro, int numeroTarjetasCredito) {
        this.id = id;
        this.nombre = nombre;
        this.numeroCuentasCorriente = numeroCuentasCorriente;
        this.numeroCuentasAhorro = numeroCuentasAhorro;
        this.numeroTarjetasCredito = numeroTarjetasCredito;
    }
}
