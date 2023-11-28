package com.unisabana.proyectobanco.controller;

import com.unisabana.proyectobanco.bd.Transaccion;
import com.unisabana.proyectobanco.bd.TransaccionRepository;
import com.unisabana.proyectobanco.dto.TransaccionDTO;
import com.unisabana.proyectobanco.logica.TransaccionLogica;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/api/transaccion")
public class TransaccionController {

    private TransaccionLogica logicaTransaccion;
    private TransaccionRepository transaccionRepository;

    @GetMapping(path = "ver")
    public List<Transaccion> obtenerTransaccion() {
        return logicaTransaccion.verTransacciones();
    }

    @PostMapping(path = "enviar")
    public String enviarDinero(@RequestBody TransaccionDTO transaccionDTO){
        Integer verificador = 0;
        try{
            logicaTransaccion.verificarSaldo(transaccionDTO);
            logicaTransaccion.inyectarDinero(transaccionDTO);
            logicaTransaccion.restarDinero(transaccionDTO);
            log.info("Se realizo la transaccion No." + (transaccionRepository.getNextValTransaccion() - 1) + " tipo " + transaccionDTO.getTipoTransaccion() + ". Se enviaron " + transaccionDTO.getValor() + " de la cuenta No." + transaccionDTO.getCuentaOrigen() +
                    " a la cuenta No." + transaccionDTO.getCuentaDestino());
            verificador = 1;
            if (verificador == 1){
                logicaTransaccion.guardarTransaccion(transaccionDTO);
            }
            return null;
        }
        catch (IllegalArgumentException exception){
            return exception.getMessage();
        }
    }

    @PostMapping(path = "deposito")
    public String hacerDeposito(@RequestBody TransaccionDTO transaccionDTO){
        try{
            logicaTransaccion.inyectarDinero(transaccionDTO);
            logicaTransaccion.guardarDeposito(transaccionDTO);
            log.info("Se realizo la transaccion No." + (transaccionRepository.getNextValTransaccion() - 1) + " tipo " + transaccionDTO.getTipoTransaccion() + ". Se depositaron " + transaccionDTO.getValor() + " COP a la cuenta No." + transaccionDTO.getCuentaDestino());
            return null;
        }
        catch (IllegalArgumentException exception){
            return  exception.getMessage();
        }

    }

}
