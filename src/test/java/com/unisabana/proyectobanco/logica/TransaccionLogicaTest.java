package com.unisabana.proyectobanco.logica;

import com.unisabana.proyectobanco.bd.Cuenta;
import com.unisabana.proyectobanco.bd.CuentaRepository;
import com.unisabana.proyectobanco.bd.Transaccion;
import com.unisabana.proyectobanco.bd.TransaccionRepository;
import com.unisabana.proyectobanco.controller.dto.TransaccionDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static jdk.jfr.internal.jfc.model.Constraint.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.never;
import static org.springframework.test.web.client.ExpectedCount.times;
@ExtendWith(MockitoExtension.class)
class TransaccionLogicaTest {
    @Mock
    private CuentaRepository cuentaRepository;

    @Autowired
    private TransaccionLogica transaccionLogica;




    @Test
    void verTrasacciones() {

    }


    @Test
    void enviarDinero() {
        // Preparación
        TransaccionDTO transaccionDTO = new TransaccionDTO();
        transaccionDTO.setCuentaDestino(1);
        transaccionDTO.setValor(10);

        Mockito.when(cuentaRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Ejecución
        transaccionLogica.enviarDinero(transaccionDTO);

        // Comprobación
        Mockito.verify(cuentaRepository, never()).save(any(Cuenta.class));

    }



    @Test
    void restarDinero() {
    }
}