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
    public void guardarCliente(ClienteDTO clienteDTO){

        if ("Manuel".equals(clienteDTO.getNombre())){
            throw new IllegalArgumentException("Nombre prohibido");
        }
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setNumeroTarjetasCredito(0);
        cliente.setNumeroCuentasCorriente(0);
        cliente.setNumeroTarjetasCredito(0);

        clienteRepository.save(cliente);
    }
}
