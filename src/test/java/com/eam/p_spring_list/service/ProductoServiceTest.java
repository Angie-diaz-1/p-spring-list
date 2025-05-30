import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Collections;
import java.util.NoSuchElementException;

import com.eam.p_spring_list.repository.ProductoRepository;
import com.eam.p_spring_list.service.ProductoService;
import com.eam.p_spring_list.entity.Producto;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

  @Test
    void listarProductos_DeberiaRetornarListaDeProductos() {
        List<Producto> lista = List.of(
            new Producto(1L, "P001", "Camisa", 50000.0, 10),
            new Producto(2L, "P002", "Pantalón", 80000.0, 5)
        );
        when(productoRepository.findAll()).thenReturn(lista);

        List<Producto> resultado = productoService.listarProductos();

        assertEquals(2, resultado.size());
        assertEquals("P001", resultado.get(0).getCodigo());
        verify(productoRepository).findAll();
    }

    @Test
    void listarProductos_DeberiaLanzarExcepcionSiNoHayProductos() {
        when(productoRepository.findAll()).thenReturn(Collections.emptyList());

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            productoService.listarProductos();
        });

        assertEquals("No hay productos registrados en la base de datos", exception.getMessage());
        verify(productoRepository).findAll();
    }


}
