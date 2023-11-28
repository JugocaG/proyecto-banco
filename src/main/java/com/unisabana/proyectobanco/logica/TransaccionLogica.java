package com.unisabana.proyectobanco.logica;

import com.unisabana.proyectobanco.bd.*;
import com.unisabana.proyectobanco.dto.TransaccionDTO;
import com.unisabana.proyectobanco.vo.TipoTransaccionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TransaccionLogica {

    private CuentaRepository cuentaRepository;
    private TransaccionRepository transaccionRepository;

    public List<Transaccion> verTransacciones(){
        return transaccionRepository.findAll();
    }

    public void inyectarDinero(TransaccionDTO transaccionDTO) throws IllegalArgumentException{
        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(transaccionDTO.getCuentaDestino());
        optionalCuenta.ifPresent(cuenta -> {
            Integer nuevaCantidad = cuenta.getSaldo() + transaccionDTO.getValor();
            cuenta.setSaldo(nuevaCantidad);
            cuentaRepository.save(cuenta);
        });

        if (!optionalCuenta.isPresent()) {
            throw new IllegalArgumentException("El numero de cuenta destino no existe");
        }
    }

    public void verificarSaldo(TransaccionDTO transaccionDTO) throws IllegalArgumentException{
        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(transaccionDTO.getCuentaOrigen());
        optionalCuenta.ifPresent(cuenta -> {
            if (cuenta.getSaldo() < transaccionDTO.getValor()){
                throw new IllegalArgumentException("Fondos insuficientes en la cuenta de origen");
            }
        });
    }

    public void restarDinero(TransaccionDTO transaccionDTO){
        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(transaccionDTO.getCuentaOrigen());
        optionalCuenta.ifPresent(cuenta -> {
            Integer nuevaCantidad = cuenta.getSaldo() - transaccionDTO.getValor();
            cuenta.setSaldo(nuevaCantidad);
            cuentaRepository.save(cuenta);
        });

        if (!optionalCuenta.isPresent()) {
            throw new IllegalArgumentException("El numero de cuenta de origen no existe");
        }

    }

    public Transaccion guardarTransaccion(TransaccionDTO transaccionDTO){
        Transaccion transaccion = new Transaccion();
        transaccion.setCuentaOrigen(transaccionDTO.getCuentaOrigen());
        transaccion.setCuentaDestino(transaccionDTO.getCuentaDestino());
        transaccion.setTipoTransaccion(TipoTransaccionEnum.TRASFERENCIA_BANCARIA);
        transaccion.setValor(transaccionDTO.getValor());
        transaccion.setFecha(LocalDateTime.now());
        transaccionRepository.save(transaccion);
        return transaccion;
    }

    public Transaccion guardarDeposito(TransaccionDTO transaccionDTO){
        Transaccion transaccion = new Transaccion();
        transaccion.setCuentaOrigen(1);
        transaccion.setTipoTransaccion(TipoTransaccionEnum.DEPOSITO_EN_EFECTIVO);
        transaccion.setCuentaDestino(transaccionDTO.getCuentaDestino());
        transaccion.setValor(transaccionDTO.getValor());
        transaccion.setFecha(LocalDateTime.now());
        transaccionRepository.save(transaccion);
        return transaccion;
    }


}
