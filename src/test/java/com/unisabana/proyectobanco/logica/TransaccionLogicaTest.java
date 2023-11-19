package com.unisabana.proyectobanco.logica;
import com.unisabana.proyectobanco.bd.Cuenta;
import com.unisabana.proyectobanco.bd.CuentaRepository;
import com.unisabana.proyectobanco.controller.dto.TransaccionDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.ExpectedCount.never;

@ExtendWith(MockitoExtension.class)
class TransaccionLogicaTest {
    @InjectMocks
    private TransaccionLogica transaccionLogica;
    @Mock
    private CuentaRepository cuentaRepository;

    @Test
    void verTrasacciones() {

    }



    @Test
    void restarDinero() {
        // Arrange
        TransaccionDTO transaccionDTO = new TransaccionDTO();
        transaccionDTO.setCuentaOrigen(123);
        transaccionDTO.setValor(1000);

        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(123);
        cuenta.setSaldo(2000);

        when(cuentaRepository.findById(123)).thenReturn(Optional.of(cuenta));

        // Act
        transaccionLogica.restarDinero(transaccionDTO);

        // Assert
        verify(cuentaRepository).save(cuenta);
        assertEquals(1000, cuenta.getSaldo());
    }
    @Test
    void restarDineroTestCuentaNoExiste() {
        // Arrange
        TransaccionDTO transaccionDTO = new TransaccionDTO();
        transaccionDTO.setCuentaOrigen(456);
        transaccionDTO.setValor(1000);

        when(cuentaRepository.findById(456)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> transaccionLogica.restarDinero(transaccionDTO));
        verify(cuentaRepository, Mockito.never()).save(any());
        }
    @Test
    void inyectarDinero(){
        // Arrange
        TransaccionDTO transaccionDTO = new TransaccionDTO();
        transaccionDTO.setCuentaDestino(123); // Replace with a valid account ID
        transaccionDTO.setValor(1000);

        Cuenta cuenta = new Cuenta(); // Replace with the actual structure of your Cuenta class
        cuenta.setSaldo(500); // Set an initial balance for testing

        Optional<Cuenta> optionalCuenta = Optional.of(cuenta);
        CuentaRepository cuentaRepository = mock(CuentaRepository.class);
        when(cuentaRepository.findById(123)).thenReturn(optionalCuenta);

        TransaccionLogica transaccionLogica = new TransaccionLogica(cuentaRepository); // Assuming YourClass has a constructor that accepts CuentaRepository

        // Act
        assertDoesNotThrow(() ->  transaccionLogica.inyectarDinero(transaccionDTO));

        // Assert
        verify(cuentaRepository, times(1)).save(any()); // Verify that save was called exactly once
        assertEquals(1500, cuenta.getSaldo());

    }
}