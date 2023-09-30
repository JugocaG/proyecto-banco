package com.unisabana.proyectobanco;

import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@RestController
public class ClienteController {

    private ClienteLogica logica;

    public ClienteController(ClienteLogica logica) {
        this.logica = logica;
    }

    @GetMapping(path = "/clientes")
    public List<Cliente> obtenerCliente() {
        return logica.verCliente();
    }

    @GetMapping(path = "/saludar")
    public String saludar(){
        return "Saludos jovenes";
    }

    @PostMapping(path = "/crear")
    public String crearCliente(@RequestBody ClienteDTO clienteDTO){

        try{
            logica.guardarCliente(clienteDTO);
            return "El cliente se guardo de manera exitosa";
        }
        catch (IllegalArgumentException e){
            return "Cliente con nombre prohibido";

        }


    }

//    @DeleteMapping(path = "/eliminar")
//    public String eliminarCliente(@RequestBody Cliente cliente){
//        clienteRepository.deleteById(cliente.getId());
//        return "El cliente se elimino con exito";
//    }
}