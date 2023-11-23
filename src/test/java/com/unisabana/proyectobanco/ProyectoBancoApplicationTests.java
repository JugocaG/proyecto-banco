package com.unisabana.proyectobanco;
import com.unisabana.proyectobanco.bd.Cliente;
import com.unisabana.proyectobanco.bd.ClienteRepository;
import com.unisabana.proyectobanco.bd.CuentaRepository;
import com.unisabana.proyectobanco.dto.ClienteDTO;
import com.unisabana.proyectobanco.logica.ClienteLogica;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles="pruebas")
@ExtendWith(MockitoExtension.class)
class ProyectoBancoApplicationTests {
    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private CuentaRepository cuentaRepository;
    @InjectMocks
    private ClienteLogica clienteLogica;


    @Test
    void dado_estudiante_guardado_correctamente() {
        ClienteDTO dto = new ClienteDTO(1, "pedro");
        Cliente cliente  = clienteLogica.guardarCliente(dto);
        Mockito.verify(clienteRepository).save(cliente);
    }
}
