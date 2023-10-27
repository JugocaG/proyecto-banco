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
        cuenta.setTipoCuenta(cuentaDTO.getTipoCuenta());
        cuenta.setNivel(cuentaDTO.getNivel());
        cuenta.setIdPropietario(cuentaDTO.getIdPropietario());
        cuenta.setSaldo(0);

        cuentaRepository.save(cuenta);

    }


}
