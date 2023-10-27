package com.unisabana.proyectobanco.bd;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
}
