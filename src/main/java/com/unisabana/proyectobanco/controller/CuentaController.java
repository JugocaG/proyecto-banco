package com.unisabana.proyectobanco.controller;

import com.unisabana.proyectobanco.bd.Cuenta;
import com.unisabana.proyectobanco.controller.dto.CuentaDTO;
import com.unisabana.proyectobanco.logica.ClienteLogica;
import com.unisabana.proyectobanco.logica.CuentaLogica;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Getter
@Setter
@RestController
public class CuentaController {

    private CuentaLogica logicaCuenta;
    private ClienteLogica logicaCliente;

    public CuentaController(CuentaLogica logicaCuenta, ClienteLogica logicaCliente) {
        this.logicaCuenta = logicaCuenta;
        this.logicaCliente = logicaCliente;
    }

    @GetMapping(path = "/cuenta/ver")
    public List<Cuenta> obtenerCuenta() {
        return getLogicaCuenta().verCuenta();
    }

    @PostMapping(path = "/cuenta/crear")
    public String crearCuenta(@RequestBody CuentaDTO cuentaDTO){
        try{
            logicaCuenta.crearCuenta(cuentaDTO);

            logicaCliente.sumarCuenta(cuentaDTO);
            return "La cuenta se creo exitosamente";
        }
        catch (HttpMessageNotReadableException ex){
            return "El tipo de cuenta que ingreso no es valido";
        }


    }
}
