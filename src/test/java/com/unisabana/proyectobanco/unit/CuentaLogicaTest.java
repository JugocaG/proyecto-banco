package com.unisabana.proyectobanco.unit;

import com.unisabana.proyectobanco.bd.Cliente;
import com.unisabana.proyectobanco.bd.ClienteRepository;
import com.unisabana.proyectobanco.bd.Cuenta;
import com.unisabana.proyectobanco.bd.CuentaRepository;
import com.unisabana.proyectobanco.controller.dto.CuentaDTO;
import com.unisabana.proyectobanco.logica.CuentaLogica;
import com.unisabana.proyectobanco.vo.CuentaEnum;
import com.unisabana.proyectobanco.vo.NivelEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
    void verCuenta(){
        // Arrange
        Cuenta cuenta1 = new Cuenta();
        cuenta1.setNumeroCuenta(1);
        cuenta1.setSaldo(100);

        Cuenta cuenta2 = new Cuenta();
        cuenta2.setNumeroCuenta(2);
        cuenta2.setSaldo(200);

        List<Cuenta> cuentas = Arrays.asList(cuenta1, cuenta2);

        // Mocking the behavior of cuentaRepository
        when(cuentaRepository.findAll()).thenReturn(cuentas);

        // Act
        List<Cuenta> result = cuentaLogica.verCuenta();

        // Assert
        assertEquals(cuentas, result);

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