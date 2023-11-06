package com.unisabana.proyectobanco.bd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

    @Query(value = "SELECT next_val FROM bancodb.secuencia_cliente", nativeQuery = true)
    public Integer getNextValCliente();
}
