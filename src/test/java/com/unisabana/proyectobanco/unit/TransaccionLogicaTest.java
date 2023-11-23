package com.unisabana.proyectobanco.unit;
import com.unisabana.proyectobanco.bd.Cuenta;
import com.unisabana.proyectobanco.bd.CuentaRepository;
import com.unisabana.proyectobanco.bd.Transaccion;
import com.unisabana.proyectobanco.bd.TransaccionRepository;
import com.unisabana.proyectobanco.dto.TransaccionDTO;
import com.unisabana.proyectobanco.logica.TransaccionLogica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
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
    @Mock
    private TransaccionRepository transaccionRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void verTransacciones() {
        // Arrange
        List<Transaccion> transaccionesMock = new ArrayList<>();
        transaccionesMock.add(new Transaccion());
        transaccionesMock.add(new Transaccion());
        when(transaccionRepository.findAll()).thenReturn(transaccionesMock);

        // Act
        List<Transaccion> result = transaccionLogica.verTransacciones();

        // Assert
        verify(transaccionRepository).findAll(); // Verifica que se haya llamado el método findAll
        assertEquals(transaccionesMock, result);

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
    @Test
    public void testGuardarDeposito() {
        // Arrange
        TransaccionDTO transaccionDTO = new TransaccionDTO(1, 2, DEPOSITO_EN_EFECTIVO, 100);

        // Act
        Transaccion result = transaccionLogica.guardarDeposito(transaccionDTO);

        // Assert
        verify(transaccionRepository).save(result); // Verifica que se haya llamado el método save con la transacción creada
        assertEquals(1, result.getCuentaOrigen()); // Ajusta esto según tu lógica real
        assertEquals(transaccionDTO.getCuentaDestino(), result.getCuentaDestino());
        assertEquals(transaccionDTO.getValor(), result.getValor());
        assertEquals(transaccionDTO.getTipoTransaccion(), result.getTipoTransaccion());
    }
    @Test
    public void testGuardarTransaccion() {
        // Arrange
        TransaccionDTO transaccionDTO = new TransaccionDTO(1, 2, DEPOSITO_EN_EFECTIVO, 100);

        // Act
        Transaccion result = transaccionLogica.guardarTransaccion(transaccionDTO);

        // Assert
        verify(transaccionRepository).save(result); // Verifica que se haya llamado el método save con la transacción creada
        assertEquals(transaccionDTO.getCuentaOrigen(), result.getCuentaOrigen());
        assertEquals(transaccionDTO.getCuentaDestino(), result.getCuentaDestino());
        assertEquals(transaccionDTO.getTipoTransaccion(), result.getTipoTransaccion());
        assertEquals(transaccionDTO.getValor(), result.getValor());
    }
}