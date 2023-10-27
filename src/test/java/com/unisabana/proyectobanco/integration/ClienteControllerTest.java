package com.unisabana.proyectobanco.integration;

import ch.qos.logback.classic.spi.TurboFilterList;
import com.unisabana.proyectobanco.controller.dto.ClienteDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "pruebas")
public class ClienteControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void guardarcliente(){
        ClienteDTO dto = new ClienteDTO();
        ResponseEntity<String> respuesta= restTemplate.postForEntity("/clientes/crear", dto,String.class);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals("El cliente se guardo de manera exitosa", respuesta.getBody());


    }
}
