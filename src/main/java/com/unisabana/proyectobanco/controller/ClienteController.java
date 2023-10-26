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
public class ClienteController {

    private ClienteLogica logicaCliente;

    public ClienteController(ClienteLogica logica) {
        this.logicaCliente = logica;
    }

    @GetMapping(path = "/clientes/ver")
    public List<Cliente> obtenerCliente() {
        return logicaCliente.verCliente();
    }

    @PostMapping(path = "/clientes/crear")
    public String crearCliente(@RequestBody ClienteDTO clienteDTO){
        try{
            logicaCliente.guardarCliente(clienteDTO);
            return new String ("El cliente se guardo de manera exitosa");
        }
        catch (IllegalArgumentException e){
            return new String("Cliente con nombre prohibido" + e.getMessage()) ;
        }
    }

//    @DeleteMapping(path = "/clientes/eliminar")
//    public String eliminarCliente(@RequestBody Cliente cliente){
//        clienteRepository.deleteById(cliente.getId());
//        return "El cliente se elimino con exito";
//    }
}