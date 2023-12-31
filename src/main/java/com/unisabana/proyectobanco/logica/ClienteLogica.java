package com.unisabana.proyectobanco.logica;

import com.unisabana.proyectobanco.vo.CuentaEnum;
import com.unisabana.proyectobanco.bd.Cliente;
import com.unisabana.proyectobanco.bd.ClienteRepository;
import com.unisabana.proyectobanco.bd.Cuenta;
import com.unisabana.proyectobanco.bd.CuentaRepository;
import com.unisabana.proyectobanco.dto.ClienteDTO;
import com.unisabana.proyectobanco.dto.CuentaDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteLogica {

    private ClienteRepository clienteRepository;

    private CuentaRepository cuentaRepository;

    public List<Cliente> verCliente(){
        return clienteRepository.findAll();
    }
    public Cliente guardarCliente(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setNumeroCuentasAhorro(0);
        cliente.setNumeroCuentasCorriente(0);
        cliente.setNumeroCuentasAhorro(0);
        clienteRepository.save(cliente);
        return cliente;
    }

    public void sumarCuenta(CuentaDTO cuentaDTO){
        Optional<Cliente> optionalCliente = clienteRepository.findById(cuentaDTO.getIdPropietario());

        optionalCliente.ifPresent(cliente -> {
            if (CuentaEnum.CUENTA_AHORROS.equals(cuentaDTO.getTipoCuenta())) {
                Integer nuevaCantidad = cliente.getNumeroCuentasAhorro() + 1;
                cliente.setNumeroCuentasAhorro(nuevaCantidad);
                clienteRepository.save(cliente);
            } else if (CuentaEnum.CUENTA_CORRIENTE.equals(cuentaDTO.getTipoCuenta())) {
                Integer nuevaCantidad = cliente.getNumeroCuentasCorriente() + 1;
                cliente.setNumeroCuentasCorriente(nuevaCantidad);
                clienteRepository.save(cliente);
            } else if (CuentaEnum.TARJETA_CREDITO.equals(cuentaDTO.getTipoCuenta())) {
                Integer nuevaCantidad = cliente.getNumeroTarjetasCredito() + 1;
                cliente.setNumeroTarjetasCredito(nuevaCantidad);
                clienteRepository.save(cliente);
            }}
        );
    }

    public void eliminarCliente(ClienteDTO clienteDTO)throws IllegalArgumentException{
        Optional<Cliente> optionalCliente = clienteRepository.findById(clienteDTO.getId());
        optionalCliente.ifPresent(cliente -> {
            clienteRepository.deleteById(cliente.getId());
        });

        if (!optionalCliente.isPresent()) {
            throw new IllegalArgumentException("No existe ningun cliente con la identificacion proporcionada");
        }

    }

    public void eliminarCuentasCliente(ClienteDTO clienteDTO){
        List<Cuenta> cuentasEliminar = cuentaRepository.findByIdPropietario(clienteDTO.getId());
        cuentasEliminar.forEach(cuenta -> {
            cuentaRepository.delete(cuenta);
        });

    }
}
