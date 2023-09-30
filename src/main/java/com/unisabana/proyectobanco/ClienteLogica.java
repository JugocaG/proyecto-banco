package com.unisabana.proyectobanco;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteLogica {

    private ClienteRepository clienteRepository;

    public ClienteLogica(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> verCliente(){
        return clienteRepository.findAll();
    }
    public void guardarCliente(Cliente cliente){

        if ("Manuel".equals(cliente.getNombre())){
            throw new IllegalArgumentException("Nombre prohibido");
        }
        clienteRepository.save(cliente);
    }
}
