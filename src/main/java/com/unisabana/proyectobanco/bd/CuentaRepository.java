package com.unisabana.proyectobanco.bd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    List<Cuenta> findByIdPropietario(Integer idPropietario);


    @Query(value = "SELECT next_val FROM bancodb.secuencia_cuenta", nativeQuery = true)
    public Integer getNextValCuenta();


}
