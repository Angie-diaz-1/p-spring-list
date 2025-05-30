package com.eam.p_spring_list.controller;

import com.eam.p_spring_list.entity.Producto;
import com.eam.p_spring_list.service.ProductoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void listarProductos_DeberiaRetornarLista() throws Exception {
        List<Producto> lista = List.of(
                new Producto(1L, "P001", "Camisa", 50000.0, 10)
        );

        when(productoService.listarProductos()).thenReturn(lista);

        mockMvc.perform(get("/api/productos/listar"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.productos[0].codigo").value("P001"));

    }

    @Test
    void listarProductos_DeberiaRetornarNotFoundSiNoHay() throws Exception {
        when(productoService.listarProductos()).thenThrow(new IllegalStateException("No hay productos"));

        mockMvc.perform(get("/api/productos/listar"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("No hay productos"));
    }
}
