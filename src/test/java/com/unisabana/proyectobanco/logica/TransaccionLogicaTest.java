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
import static com.unisabana.proyectobanco.vo.TipoTransaccionEnum.DEPOSITO_EN_EFECTIVO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        TransaccionDTO transaccionDTO = new TransaccionDTO(1,2,DEPOSITO_EN_EFECTIVO,3 );
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
        TransaccionDTO transaccionDTO = new TransaccionDTO(1,2,DEPOSITO_EN_EFECTIVO,3 );
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
        TransaccionDTO transaccionDTO = new TransaccionDTO(1,2,DEPOSITO_EN_EFECTIVO,3 );
        transaccionDTO.setCuentaDestino(123);
        transaccionDTO.setValor(1000);

        Cuenta cuenta = new Cuenta();
        cuenta.setSaldo(500);

        Optional<Cuenta> optionalCuenta = Optional.of(cuenta);
        CuentaRepository cuentaRepository = mock(CuentaRepository.class);
        when(cuentaRepository.findById(123)).thenReturn(optionalCuenta);

        TransaccionLogica transaccionLogica = new TransaccionLogica(cuentaRepository);

        // Act
        assertDoesNotThrow(() ->  transaccionLogica.inyectarDinero(transaccionDTO));

        // Assert
        verify(cuentaRepository, times(1)).save(any());
        assertEquals(1500, cuenta.getSaldo());

    }
}