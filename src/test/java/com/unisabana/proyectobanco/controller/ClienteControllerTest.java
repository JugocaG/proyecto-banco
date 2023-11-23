package com.unisabana.proyectobanco.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unisabana.proyectobanco.bd.Cliente;
import com.unisabana.proyectobanco.controller.dto.ClienteDTO;
import com.unisabana.proyectobanco.logica.ClienteLogica;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Puedes usar Mockito para simular la lógica del servicio
    @MockBean
    private ClienteLogica clienteLogica;
/*
    @Test
    void obtenerCliente() throws Exception {
        // Arrange
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();

        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);

        // Simula el comportamiento de logicaCliente.verCliente()
        when(clienteLogica.verCliente()).thenReturn(clientes);

        // Act
        ResultActions result = mockMvc.perform(get("/ver").contentType(MediaType.APPLICATION_JSON));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect((ResultMatcher) jsonPath("$[0].id", is(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].nombre", is("Cliente1")))
                .andExpect((ResultMatcher) jsonPath("$[1].id", is(2)))
                .andExpect((ResultMatcher) jsonPath("$[1].nombre", is("Cliente2")));
    }


    @Test
    void crearCliente()  {
    }

    @Test
    void eliminarCliente() throws Exception {
        // Arrange
        ClienteDTO clienteDTO = new ClienteDTO(1, "sebastian");
        clienteDTO.setId(1);

        // Act
        mockMvc.perform(MockMvcRequestBuilders.delete("/eliminar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Assert
        verify(clienteLogica).eliminarCuentasCliente(clienteDTO);
        verify(clienteLogica).eliminarCliente(clienteDTO);
    }
    */
}