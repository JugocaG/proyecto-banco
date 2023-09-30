package com.unisabana.proyectobanco.unit;

import com.unisabana.proyectobanco.Cliente;
import com.unisabana.proyectobanco.ClienteDTO;
import com.unisabana.proyectobanco.ClienteLogica;
import com.unisabana.proyectobanco.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
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
        ClienteDTO dto = new ClienteDTO(1,"pedro",1,1,1);
        Cliente cliente  = clienteLogica.guardarCliente(dto);
        Mockito.verify(clienteRepository).save(cliente);
    }
    @Test
    void Dado_cliente_prohibido_Cuando_intente_guardar_Entonces_arroja_excepxion() {
        ClienteDTO dto = new ClienteDTO(1,"Manuel",1,1,1);
        assertThrows(IllegalArgumentException.class, () ->{
            clienteLogica.guardarCliente(dto);
        });
    }

}
