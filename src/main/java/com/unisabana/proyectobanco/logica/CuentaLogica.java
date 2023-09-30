package com.unisabana.proyectobanco.logica;

import com.unisabana.proyectobanco.bd.Cuenta;
import com.unisabana.proyectobanco.bd.CuentaRepository;
import com.unisabana.proyectobanco.controller.dto.CuentaDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaLogica {


    private CuentaRepository cuentaRepository;

    public CuentaLogica(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public List<Cuenta> verCuenta(){
        return cuentaRepository.findAll();
    }

    public void crearCuenta(CuentaDTO cuentaDTO){
        Cuenta cuenta = new Cuenta();
        cuenta.setNumero_cuenta(cuentaDTO.getNumero_cuenta());
        cuenta.setTipo_cuenta(cuentaDTO.getTipo_cuenta());
        cuenta.setNivel(cuentaDTO.getNivel());
        cuenta.setId_propietario(cuentaDTO.getId_propietario());
        cuenta.setSaldo(0);

        cuentaRepository.save(cuenta);

    }


}
