package com.unisabana.proyectobanco.logica;

import com.unisabana.proyectobanco.bd.*;
import com.unisabana.proyectobanco.controller.dto.TransaccionDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@Setter

@Service
public class TransaccionLogica {

    private CuentaRepository cuentaRepository;
    private TransaccionRepository transaccionRepository;

    public TransaccionLogica(CuentaRepository cuentaRepository, TransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }

    public List<Transaccion> verTrasacciones(){
        return transaccionRepository.findAll();
    }

    public void enviarDinero(TransaccionDTO transaccionDTO){
        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(transaccionDTO.getCuentaDestino());
        optionalCuenta.ifPresent(cuenta -> {
            Integer nuevaCantidad = cuenta.getSaldo() + transaccionDTO.getValor();
            cuenta.setSaldo(nuevaCantidad);
            cuentaRepository.save(cuenta);
        });
    }

    public void restarDinero(TransaccionDTO transaccionDTO){
        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(transaccionDTO.getCuentaOrigen());
        optionalCuenta.ifPresent(cuenta -> {
            Integer nuevaCantidad = cuenta.getSaldo() - transaccionDTO.getValor();
            cuenta.setSaldo(nuevaCantidad);
            cuentaRepository.save(cuenta);
        });
    }

    public Transaccion guardarTransaccion(TransaccionDTO transaccionDTO){
        Transaccion transaccion = new Transaccion();
        transaccion.setCuentaOrigen(transaccionDTO.getCuentaOrigen());
        transaccion.setCuentaDestino(transaccionDTO.getCuentaDestino());
        transaccion.setValor(transaccionDTO.getValor());
        transaccion.setFecha(LocalDateTime.now());
        transaccionRepository.save(transaccion);
        return transaccion;
    }

    public void hacerDeposito(TransaccionDTO transaccionDTO){

    }


}
