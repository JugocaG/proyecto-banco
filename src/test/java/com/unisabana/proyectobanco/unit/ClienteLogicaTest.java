package com.unisabana.proyectobanco.unit;

import com.unisabana.proyectobanco.CuentaEnum;
import com.unisabana.proyectobanco.bd.Cliente;
import com.unisabana.proyectobanco.bd.ClienteRepository;
import com.unisabana.proyectobanco.controller.dto.ClienteDTO;
import com.unisabana.proyectobanco.controller.dto.CuentaDTO;

import com.unisabana.proyectobanco.logica.ClienteLogica;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class ClienteLogicaTest {
    @Mock
    private ClienteRepository clienteRepository;
    @InjectMocks
    private ClienteLogica clienteLogica;

    @Test
    void verCliente() {

    }


    @Test
    void dado_estudiante_guardado_correctamente() {
        ClienteDTO dto = new ClienteDTO(1,"pedro");
        Cliente cliente  = clienteLogica.guardarCliente(dto);
        Mockito.verify(clienteRepository).save(cliente);
    }
    @Test
    void Dado_cliente_prohibido_Cuando_intente_guardar_Entonces_arroja_excepxion() {
        ClienteDTO dto = new ClienteDTO(1,"Manuel");
        assertThrows(IllegalArgumentException.class, () ->{
            clienteLogica.guardarCliente(dto);
        });
    }
    @Test
    void debeSumarUnaCuentaAhorro() {
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId_propietario(1);
        cuentaDTO.setTipo_cuenta(CuentaEnum.CUENTA_AHORROS);

        // Simula el clienteRepository con Mockito
        ClienteRepository clienteRepository = Mockito.mock(ClienteRepository.class);
        Cliente cliente = new Cliente();
        cliente.setNumeroCuentasAhorro(2);
        Mockito.when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente));

        // Crea una instancia de ClienteLogica con el clienteRepository simulado
        ClienteLogica clienteLogica = new ClienteLogica(clienteRepository);
        clienteLogica.sumarCuenta(cuentaDTO);

        // Verifica que el método save del repositorio se haya llamado con el cliente modificado
        Mockito.verify(clienteRepository).save(cliente);


    }
    @Test
    void debeSumarUnaCuentaCorriente() {
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId_propietario(1);
        cuentaDTO.setTipo_cuenta(CuentaEnum.CUENTA_CORRIENTE);

        // Simula el clienteRepository con Mockito
        ClienteRepository clienteRepository = Mockito.mock(ClienteRepository.class);
        Cliente cliente = new Cliente();
        cliente.setNumeroCuentasCorriente(2);
        Mockito.when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente));

        // Crea una instancia de ClienteLogica con el clienteRepository simulado
        ClienteLogica clienteLogica = new ClienteLogica(clienteRepository);
        clienteLogica.sumarCuenta(cuentaDTO);

        // Verifica que el método save del repositorio se haya llamado con el cliente modificado
        Mockito.verify(clienteRepository).save(cliente);


    }
    @Test
    void debeSumarTarjeta() {
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId_propietario(1);
        cuentaDTO.setTipo_cuenta(CuentaEnum.TARJETA_CREDITO);

        // Simula el clienteRepository con Mockito
        ClienteRepository clienteRepository = Mockito.mock(ClienteRepository.class);
        Cliente cliente = new Cliente();
        cliente.setNumeroTarjetasCredito(2);
        Mockito.when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente));

        // Crea una instancia de ClienteLogica con el clienteRepository simulado
        ClienteLogica clienteLogica = new ClienteLogica(clienteRepository);
        clienteLogica.sumarCuenta(cuentaDTO);

        // Verifica que el método save del repositorio se haya llamado con el cliente modificado
        Mockito.verify(clienteRepository).save(cliente);
    }


}
