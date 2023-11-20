package com.unisabana.proyectobanco.logica;
import com.unisabana.proyectobanco.CuentaEnum;
import com.unisabana.proyectobanco.NivelEnum;
import com.unisabana.proyectobanco.bd.Cliente;
import com.unisabana.proyectobanco.bd.ClienteRepository;
import com.unisabana.proyectobanco.bd.Cuenta;
import com.unisabana.proyectobanco.bd.CuentaRepository;
import com.unisabana.proyectobanco.controller.dto.CuentaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import java.util.Optional;

class CuentaLogicaTest {
    @InjectMocks
    private CuentaLogica cuentaLogica;

    @Mock
    private CuentaRepository cuentaRepository;

    @Mock
    private ClienteRepository clienteRepository;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void verificarExistenciaCliente() {
        // Arrange
        CuentaDTO cuentaDTO = new CuentaDTO(1, CuentaEnum.CUENTA_CORRIENTE, NivelEnum.GENERAL, 4);
        cuentaDTO.setIdPropietario(123);

        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("Juan");

        when(clienteRepository.findById(123)).thenReturn(Optional.of(cliente));

        // Act
        cuentaLogica.verificarExistenciaCliente(cuentaDTO);

        // Assert
        verify(clienteRepository).findById(123);

    }

    @Test
    void crearCuenta() {
        // Arrange
        CuentaDTO cuentaDTO = new CuentaDTO(1, CuentaEnum.CUENTA_CORRIENTE, NivelEnum.GENERAL, 4);
        cuentaDTO.setIdPropietario(123);
        cuentaDTO.setTipoCuenta(CuentaEnum.CUENTA_CORRIENTE);
        cuentaDTO.setNivel(NivelEnum.GENERAL);

        Cuenta cuenta = new Cuenta();
        cuenta.setTipoCuenta(CuentaEnum.CUENTA_CORRIENTE);
        cuenta.setNivel(NivelEnum.GENERAL);
        cuenta.setIdPropietario(123);
        cuenta.setSaldo(0);

        when(cuentaRepository.save(any(Cuenta.class))).thenReturn(cuenta);

        // Act
        cuentaLogica.crearCuenta(cuentaDTO);

        // Assert
        verify(cuentaRepository).save(any(Cuenta.class));

    }

    @Test
    void eliminarCuenta() {
        // Arrange
        CuentaDTO cuentaDTO = new CuentaDTO(1, CuentaEnum.CUENTA_CORRIENTE, NivelEnum.GENERAL, 4);
        cuentaDTO.setId(1);

        Cuenta cuenta = new Cuenta();
        when(cuentaRepository.findById(cuentaDTO.getId())).thenReturn(Optional.of(cuenta));

        // Act
        cuentaLogica.eliminarCuenta(cuentaDTO);

        // Assert
        verify(cuentaRepository, times(1)).deleteById(cuentaDTO.getId());



    }
}