package com.unisabana.proyectobanco.bd;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    List<Cuenta> findByIdPropietario(Integer idPropietario);

}
