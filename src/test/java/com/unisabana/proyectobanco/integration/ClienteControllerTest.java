package com.unisabana.proyectobanco.integration;


import com.unisabana.proyectobanco.ClienteDTO;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ClienteControllerTest {


    private TestRestTemplate restTemplate;
    @Test
    public void guardarCliente(){
        ClienteDTO dto = new ClienteDTO(1,"pedro",1,1,1);

        ResponseEntity<ClienteDTO> cliente = restTemplate.postForEntity("/crear",dto,ClienteDTO.class);

        Assertions.assertEquals("El cliente se guardo de manera exitosa",cliente.getBody());
    }
}
*/