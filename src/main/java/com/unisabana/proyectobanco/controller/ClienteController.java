package com.unisabana.proyectobanco.controller;

import com.unisabana.proyectobanco.bd.ClienteRepository;
import com.unisabana.proyectobanco.logica.ClienteLogica;
import com.unisabana.proyectobanco.bd.Cliente;
import com.unisabana.proyectobanco.controller.dto.ClienteDTO;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/cliente")
public class ClienteController {

    private ClienteLogica logicaCliente;
    private ClienteRepository clienteRepository;

    @GetMapping(path = "ver")
    public List<Cliente> obtenerCliente() {
        return logicaCliente.verCliente();
    }

    @PostMapping(path = "crear")
    public String crearCliente(@RequestBody ClienteDTO clienteDTO){
        logicaCliente.guardarCliente(clienteDTO);
        log.info("Se creo el cliente No." + (clienteRepository.getNextValCliente() - 1) + " a nombre de " + clienteDTO.getNombre());
        return null;
    }

    @DeleteMapping(path = "eliminar")
    public String eliminarCliente(@RequestBody ClienteDTO clienteDTO){
        try{
            logicaCliente.eliminarCuentasCliente(clienteDTO);
            logicaCliente.eliminarCliente(clienteDTO);
            log.info("Se elimino el cliente No." + clienteDTO.getId() + " junto con todas las cuentas asociadas");
            return null;
        }
        catch (IllegalArgumentException exception){
            return exception.getMessage();
        }



    }
}