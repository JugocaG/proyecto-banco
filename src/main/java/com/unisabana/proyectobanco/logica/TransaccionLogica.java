package com.unisabana.proyectobanco.logica;

import com.unisabana.proyectobanco.CuentaEnum;
import com.unisabana.proyectobanco.bd.Cliente;
import com.unisabana.proyectobanco.bd.Cuenta;
import com.unisabana.proyectobanco.bd.CuentaRepository;
import com.unisabana.proyectobanco.bd.TransaccionRepository;
import com.unisabana.proyectobanco.controller.dto.CuentaDTO;
import com.unisabana.proyectobanco.controller.dto.TransaccionDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

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

    public void enviarDinero(TransaccionDTO transaccionDTO){
        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(transaccionDTO.getCuenta_origen());
        optionalCuenta.ifPresent(cuenta -> {
            Integer nuevaCantidad = cuenta.getSaldo() + transaccionDTO.getValor();
            cuenta.setSaldo(nuevaCantidad);
            cuentaRepository.save(cuenta);
        });

    }
}
