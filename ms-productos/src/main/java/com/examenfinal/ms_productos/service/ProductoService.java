package com.examenfinal.ms_productos.service;

import com.examenfinal.ms_productos.entity.Producto;
import com.examenfinal.ms_productos.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public Producto crear(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    public Producto actualizar(Long id, Producto actualizado) {
        Producto producto = productoRepository.findById(id).orElseThrow();
        producto.setNombre(actualizado.getNombre());
        producto.setPrecio(actualizado.getPrecio());
        producto.setCategoria(actualizado.getCategoria());
        return productoRepository.save(producto);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
