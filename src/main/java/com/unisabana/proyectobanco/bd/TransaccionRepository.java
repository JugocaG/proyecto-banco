package com.unisabana.proyectobanco.bd;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository <Transaccion, Integer> {
}
