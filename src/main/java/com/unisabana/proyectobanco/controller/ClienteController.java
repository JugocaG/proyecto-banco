package com.unisabana.proyectobanco.controller;

import com.unisabana.proyectobanco.logica.ClienteLogica;
import com.unisabana.proyectobanco.bd.Cliente;
import com.unisabana.proyectobanco.controller.dto.ClienteDTO;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@RestController
@RequestMapping(path = "/api/cliente")
public class ClienteController {

    private ClienteLogica logicaCliente;

    public ClienteController(ClienteLogica logica) {
        this.logicaCliente = logica;
    }

    @GetMapping(path = "/ver")
    public List<Cliente> obtenerCliente() {
        return logicaCliente.verCliente();
    }

    @PostMapping(path = "/crear")
    public String crearCliente(@RequestBody ClienteDTO clienteDTO){
        try{
            logicaCliente.guardarCliente(clienteDTO);
            return "El cliente se guardo de manera exitosa";
        }
        catch (IllegalArgumentException e){
            return "Cliente con nombre prohibido" + e.getMessage();
        }
    }

    @DeleteMapping(path = "/eliminar")
    public String eliminarCliente(@RequestBody ClienteDTO clienteDTO){
        logicaCliente.eliminarCuentasCliente(clienteDTO);
        logicaCliente.eliminarCliente(clienteDTO);

        return "El cliente se elimino con exito";
    }
}