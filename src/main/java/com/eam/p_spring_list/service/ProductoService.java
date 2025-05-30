package com.eam.p_spring_list.service;

import com.eam.p_spring_list.entity.Producto;
import com.eam.p_spring_list.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.NoSuchElementException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<Producto> listarProductos() {
        List<Producto> productos = productoRepository.findAll();
        if (productos.isEmpty()) {
            throw new IllegalStateException("No hay productos registrados en la base de datos");
        }
        return productos;
    }

}
