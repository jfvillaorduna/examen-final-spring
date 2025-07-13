package com.examenfinal.ms_productos.repository;

import com.examenfinal.ms_productos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
