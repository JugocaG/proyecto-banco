package com.unisabana.proyectobanco.controller;

import com.unisabana.proyectobanco.bd.Cuenta;
import com.unisabana.proyectobanco.bd.CuentaRepository;
import com.unisabana.proyectobanco.controller.dto.CuentaDTO;
import com.unisabana.proyectobanco.logica.ClienteLogica;
import com.unisabana.proyectobanco.logica.CuentaLogica;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/api/cuenta")
public class CuentaController {

    final int RESTA_ULTIMO_NUMERO_SECUENCIA = 1;

    private CuentaLogica logicaCuenta;
    private ClienteLogica logicaCliente;
    private CuentaRepository cuentaRepository;

    @GetMapping(path = "ver")
    public List<Cuenta> obtenerCuenta() {
        return logicaCuenta.verCuenta();
    }

    @PostMapping(path = "crear")
    public String crearCuenta(@RequestBody CuentaDTO cuentaDTO){
        try{
            logicaCuenta.verificarExistenciaCliente(cuentaDTO);
            logicaCuenta.crearCuenta(cuentaDTO);
            logicaCliente.sumarCuenta(cuentaDTO);
            log.info("Se creo la cuenta No." + (cuentaRepository.getNextValCuenta() - RESTA_ULTIMO_NUMERO_SECUENCIA) + " a nombre del cliente No." + cuentaDTO.getIdPropietario());
            return null;
        }
        catch (IllegalArgumentException exception){
            return exception.getMessage();
        }
    }

    @DeleteMapping(path = "eliminar")
    public String eliminarCliente(@RequestBody CuentaDTO cuentaDTO){
        try
        {
            logicaCuenta.eliminarCuenta(cuentaDTO);
            log.info("Se elimino la cuenta No." + cuentaDTO.getId());
            return null;
        }
        catch (IllegalArgumentException exception){
            return exception.getMessage();
        }
    }
}
