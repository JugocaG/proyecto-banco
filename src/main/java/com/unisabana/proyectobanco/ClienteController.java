package com.unisabana.proyectobanco;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Getter
@Setter
@RestController
public class ClienteController {
    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping(path = "/clientes")
    public List<Cliente> obtenerCliente() {

        return clienteRepository.findAll();
    }

    @GetMapping(path = "/saludar")
    public String saludar(){
        return "Saludos jovenes";
    }
}