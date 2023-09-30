package com.unisabana.proyectobanco.logica;

import com.unisabana.proyectobanco.CuentaEnum;
import com.unisabana.proyectobanco.bd.Cliente;
import com.unisabana.proyectobanco.bd.ClienteRepository;
import com.unisabana.proyectobanco.controller.dto.ClienteDTO;
import com.unisabana.proyectobanco.controller.dto.CuentaDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setNumeroTarjetasCredito(0);
        cliente.setNumeroCuentasCorriente(0);
        cliente.setNumeroTarjetasCredito(0);
        clienteRepository.save(cliente);
    }

    public void sumarCuenta(CuentaDTO cuentaDTO){
        Optional<Cliente> optionalCliente = clienteRepository.findById(cuentaDTO.getId_propietario());

        optionalCliente.ifPresent(cliente -> {
            if (CuentaEnum.CUENTA_AHORROS.equals(cuentaDTO.getTipo_cuenta())){
                Integer nuevaCantidad = cliente.getNumeroCuentasAhorro() + 1;
                cliente.setNumeroCuentasAhorro(nuevaCantidad);
                clienteRepository.save(cliente);
            } else if (CuentaEnum.CUENTA_CORRIENTE.equals(cuentaDTO.getTipo_cuenta())) {
                Integer nuevaCantidad = cliente.getNumeroCuentasCorriente() + 1;
                cliente.setNumeroCuentasCorriente(nuevaCantidad);
                clienteRepository.save(cliente);
            } else if (CuentaEnum.TARJETA_CREDITO.equals(cuentaDTO.getTipo_cuenta())) {
                Integer nuevaCantidad = cliente.getNumeroTarjetasCredito() + 1;
                cliente.setNumeroTarjetasCredito(nuevaCantidad);
                clienteRepository.save(cliente);
            }
        });

    }
}
