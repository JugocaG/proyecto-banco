package com.unisabana.proyectobanco.controller;

import com.unisabana.proyectobanco.bd.Transaccion;
import com.unisabana.proyectobanco.controller.dto.TransaccionDTO;
import com.unisabana.proyectobanco.logica.TransaccionLogica;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Getter
@Setter

@RestController
@RequestMapping(path = "/api/transaccion")
public class TransaccionController {

    private TransaccionLogica logicaTransaccion;

    public TransaccionController(TransaccionLogica logicaTransaccion) {
        this.logicaTransaccion = logicaTransaccion;
    }

    @PostMapping(path = "enviar")
    public String enviarDinero(@RequestBody TransaccionDTO transaccionDTO){
        logicaTransaccion.enviarDinero(transaccionDTO);
        logicaTransaccion.guardarTransaccion(transaccionDTO);
        logicaTransaccion.restarDinero(transaccionDTO);
        return "La transaccion se ha realizado con exito";
    }

    @GetMapping(path = "ver")
    public List<Transaccion> obtenerTransaccion() {
        return logicaTransaccion.verTrasacciones();
    }

    @PostMapping(path = "deposito")
    public String hacerDeposito(@RequestBody TransaccionDTO transaccionDTO){
        return "El deposito se ha realizado con exito";
    }
}
