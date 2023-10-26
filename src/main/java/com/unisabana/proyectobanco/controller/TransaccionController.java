package com.unisabana.proyectobanco.controller;

import com.unisabana.proyectobanco.controller.dto.CuentaDTO;
import com.unisabana.proyectobanco.controller.dto.TransaccionDTO;
import com.unisabana.proyectobanco.logica.TransaccionLogica;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter

@RestController
public class TransaccionController {

    private TransaccionLogica logicaTransaccion;

    public TransaccionController(TransaccionLogica logicaTransaccion) {
        this.logicaTransaccion = logicaTransaccion;
    }

    @PostMapping(path = "/transaccion/enviar")
    public String enviarDinero(@RequestBody TransaccionDTO transaccionDTO){
        logicaTransaccion.enviarDinero(transaccionDTO);
        return "La transaccion se ha realizado con exito";
    }
}
