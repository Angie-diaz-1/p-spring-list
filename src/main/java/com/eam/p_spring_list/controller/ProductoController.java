package com.eam.p_spring_list.controller;

import com.eam.p_spring_list.entity.Producto;
import com.eam.p_spring_list.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listarProductos() {
        try {
            List<Producto> productos = productoService.listarProductos();

            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "Lista de productos obtenida correctamente.");
            response.put("productos", productos);

            return ResponseEntity.ok(response);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
