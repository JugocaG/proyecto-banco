package com.unisabana.proyectobanco.unit;

import com.unisabana.proyectobanco.vo.CuentaEnum;
import com.unisabana.proyectobanco.vo.NivelEnum;
import com.unisabana.proyectobanco.bd.Cliente;
import com.unisabana.proyectobanco.bd.ClienteRepository;
import com.unisabana.proyectobanco.bd.Cuenta;
import com.unisabana.proyectobanco.bd.CuentaRepository;
import com.unisabana.proyectobanco.controller.dto.ClienteDTO;
import com.unisabana.proyectobanco.controller.dto.CuentaDTO;
import com.unisabana.proyectobanco.logica.ClienteLogica;
import com.unisabana.proyectobanco.logica.CuentaLogica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ClienteLogicaTest {
    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private CuentaRepository cuentaRepository;
    @InjectMocks
    private ClienteLogica clienteLogica;
    @InjectMocks
    private CuentaLogica cuentaLogica;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void dado_cliente_guardado_correctamente() {
        ClienteDTO dto = new ClienteDTO(1, "pedro");
        Cliente cliente  = clienteLogica.guardarCliente(dto);
        Mockito.verify(clienteRepository).save(cliente);
    }
//    @Test
//    void Dado_cliente_prohibido_Cuando_intente_guardar_Entonces_arroja_excepxion() {
//        ClienteDTO dto = new ClienteDTO();
//        assertThrows(IllegalArgumentException.class, () ->{
//            clienteLogica.guardarCliente(dto);
//        });
//    }
    @Test
    void debeSumarUnaCuentaAhorro() {
        CuentaDTO cuentaDTO = new CuentaDTO(1, CuentaEnum.CUENTA_AHORROS, NivelEnum.EJECUTIVA, 1);
        cuentaDTO.setIdPropietario(1);
        cuentaDTO.setTipoCuenta(CuentaEnum.CUENTA_AHORROS);

        // Simula el clienteRepository con Mockito
        ClienteRepository clienteRepository = Mockito.mock(ClienteRepository.class);
        Cliente cliente = new Cliente();
        cliente.setNumeroCuentasAhorro(2);
        when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente));

        // Crea una instancia de ClienteLogica con el clienteRepository simulado
        ClienteLogica clienteLogica = new ClienteLogica(clienteRepository, cuentaRepository);
        clienteLogica.sumarCuenta(cuentaDTO);

        // Verifica que el método save del repositorio se haya llamado con el cliente modificado
        Mockito.verify(clienteRepository).save(cliente);


    }
    @Test
    void debeSumarUnaCuentaCorriente() {
        CuentaDTO cuentaDTO = new CuentaDTO(1, CuentaEnum.CUENTA_CORRIENTE, NivelEnum.EJECUTIVA, 1);
        cuentaDTO.setIdPropietario(1);
        cuentaDTO.setTipoCuenta(CuentaEnum.CUENTA_CORRIENTE);

        // Simula el clienteRepository con Mockito
        ClienteRepository clienteRepository = Mockito.mock(ClienteRepository.class);
        Cliente cliente = new Cliente();
        cliente.setNumeroCuentasCorriente(2);
        when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente));

        // Crea una instancia de ClienteLogica con el clienteRepository simulado
        ClienteLogica clienteLogica = new ClienteLogica(clienteRepository, cuentaRepository);
        clienteLogica.sumarCuenta(cuentaDTO);

        // Verifica que el método save del repositorio se haya llamado con el cliente modificado
        Mockito.verify(clienteRepository).save(cliente);


    }
    @Test
    void debeSumarTarjeta() {
        CuentaDTO cuentaDTO = new CuentaDTO(1, CuentaEnum.TARJETA_CREDITO, NivelEnum.EJECUTIVA, 1);
        cuentaDTO.setIdPropietario(1);
        cuentaDTO.setTipoCuenta(CuentaEnum.TARJETA_CREDITO);

        // Simula el clienteRepository con Mockito
        ClienteRepository clienteRepository = Mockito.mock(ClienteRepository.class);
        Cliente cliente = new Cliente();
        cliente.setNumeroTarjetasCredito(2);
        when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente));

        // Crea una instancia de ClienteLogica con el clienteRepository simulado
        ClienteLogica clienteLogica = new ClienteLogica(clienteRepository, cuentaRepository);
        clienteLogica.sumarCuenta(cuentaDTO);

        // Verifica que el método save del repositorio se haya llamado con el cliente modificado
        Mockito.verify(clienteRepository).save(cliente);
    }
    @Test
    void verCliente() {
        // Arrange
        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNombre("Cliente1");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2);
        cliente2.setNombre("Cliente2");

        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);

        // Mocking the behavior of clienteRepository
        when(clienteRepository.findAll()).thenReturn(clientes);

        // Act
        List<Cliente> result = clienteLogica.verCliente();

        // Assert
        assertEquals(clientes, result);
    }



    @Test
    void eliminarCliente() {
        // Arrange
        ClienteDTO clienteDTO = new ClienteDTO(1, "sebastian");
        clienteDTO.setId(1);

        Cliente cliente = new Cliente();
        cliente.setId(1);

        Optional<Cliente> optionalCliente = Optional.of(cliente);

        // Mocking the behavior of clienteRepository
        when(clienteRepository.findById(clienteDTO.getId())).thenReturn(optionalCliente);

        // Act
        clienteLogica.eliminarCliente(clienteDTO);

        // Assert
        verify(clienteRepository, times(1)).deleteById(cliente.getId());
    }
    @Test
    public void testEliminarClienteClienteNoEncontrado() {
        // Arrange
        ClienteDTO clienteDTO = new ClienteDTO(1, "sebastian");
        clienteDTO.setId(1);

        Optional<Cliente> optionalCliente = Optional.empty();

        // Mocking the behavior of clienteRepository
        when(clienteRepository.findById(clienteDTO.getId())).thenReturn(optionalCliente);

        // Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> clienteLogica.eliminarCliente(clienteDTO));

        // Verificar el mensaje de la excepción
        assertEquals("No existe ningun cliente con la identificacion proporcionada", exception.getMessage());
    }

    @Test
    void eliminarCuentasCliente() {
        // Arrange
        ClienteDTO clienteDTO = new ClienteDTO(1, "sebastian");
        clienteDTO.setId(1);

        Cuenta cuenta1 = new Cuenta();
        cuenta1.setIdPropietario(1);
        cuenta1.setIdPropietario(clienteDTO.getId());

        Cuenta cuenta2 = new Cuenta();
        cuenta2.setIdPropietario(2);
        cuenta2.setIdPropietario(clienteDTO.getId());

        List<Cuenta> cuentas = Arrays.asList(cuenta1, cuenta2);

        // Mocking the behavior of cuentaRepository
        when(cuentaRepository.findByIdPropietario(clienteDTO.getId())).thenReturn(cuentas);

        // Act
        clienteLogica.eliminarCuentasCliente(clienteDTO);

        // Assert
        verify(cuentaRepository, times(2)).delete(any());
    }


}
