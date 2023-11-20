package com.unisabana.proyectobanco.logica;

import com.unisabana.proyectobanco.bd.Cliente;
import com.unisabana.proyectobanco.bd.ClienteRepository;
import com.unisabana.proyectobanco.bd.Cuenta;
import com.unisabana.proyectobanco.bd.CuentaRepository;
import com.unisabana.proyectobanco.controller.dto.CuentaDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Slf4j
public class CuentaLogica {
    private CuentaRepository cuentaRepository;

    private ClienteRepository clienteRepository;



    public List<Cuenta> verCuenta(){
        return cuentaRepository.findAll();
    }

    public void verificarExistenciaCliente(CuentaDTO cuentaDTO){
        Optional<Cliente> optionalCliente = clienteRepository.findById(cuentaDTO.getIdPropietario());
        if (!optionalCliente.isPresent()) {
            throw new IllegalArgumentException("No existe ningun cliente con la identificacion proporcionada");
        }
    }
    public void crearCuenta(CuentaDTO cuentaDTO)throws IllegalArgumentException{
        Cuenta cuenta = new Cuenta();
        cuenta.setTipoCuenta(cuentaDTO.getTipoCuenta());
        cuenta.setNivel(cuentaDTO.getNivel());
        cuenta.setIdPropietario(cuentaDTO.getIdPropietario());
        cuenta.setSaldo(0);
        cuentaRepository.save(cuenta);
    }

    public void eliminarCuenta(CuentaDTO cuentaDTO){
        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(cuentaDTO.getId());

        optionalCuenta.ifPresent(cuenta ->{
            cuentaRepository.deleteById(cuentaDTO.getId());
        });

        if (!optionalCuenta.isPresent()) {
            throw new IllegalArgumentException("No existe ninguna cuenta con la identificacion proporcionada");

        }
    }




}
