package com.unisabana.proyectobanco.controller;

import com.unisabana.proyectobanco.bd.Cuenta;
import com.unisabana.proyectobanco.controller.dto.ClienteDTO;
import com.unisabana.proyectobanco.controller.dto.CuentaDTO;
import com.unisabana.proyectobanco.logica.ClienteLogica;
import com.unisabana.proyectobanco.logica.CuentaLogica;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@RestController
@RequestMapping(path = "/api/cuenta")
public class CuentaController {

    private CuentaLogica logicaCuenta;
    private ClienteLogica logicaCliente;

    public CuentaController(CuentaLogica logicaCuenta, ClienteLogica logicaCliente) {
        this.logicaCuenta = logicaCuenta;
        this.logicaCliente = logicaCliente;
    }

    @GetMapping(path = "ver")
    public List<Cuenta> obtenerCuenta() {
        return getLogicaCuenta().verCuenta();
    }

    @PostMapping(path = "crear")
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

    @DeleteMapping(path = "eliminar")
    public String eliminarCliente(@RequestBody CuentaDTO cuentaDTO){
        logicaCuenta.eliminarCuenta(cuentaDTO);
        return "El cliente se elimino con exito";
    }
}
