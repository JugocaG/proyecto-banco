package com.unisabana.proyectobanco.bd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransaccionRepository extends JpaRepository <Transaccion, Integer> {

    @Query(value = "SELECT next_val FROM bancodb.secuencia_transaccion", nativeQuery = true)
    public Integer getNextValTransaccion();

}
