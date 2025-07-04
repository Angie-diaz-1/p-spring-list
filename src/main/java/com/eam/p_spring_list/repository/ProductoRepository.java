package com.eam.p_spring_list.repository;

import com.eam.p_spring_list.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Verifica si ya existe un producto con un código específico
    boolean existsByCodigo(String codigo);

    // Busca un producto por su código único
    Optional<Producto> findByCodigo(String codigo);

    // Elimina un producto por su código
    void deleteByCodigo(String codigo);
}
