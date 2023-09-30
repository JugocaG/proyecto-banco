package com.unisabana.proyectobanco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    private int id;
    private String nombre;
    private int numeroCuentasCorriente;
    private int numeroCuentasAhorro;
    private int numeroTarjetasCredito;
}
