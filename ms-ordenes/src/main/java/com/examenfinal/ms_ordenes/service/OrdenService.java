package com.examenfinal.ms_ordenes.service;

import com.examenfinal.ms_ordenes.entity.Orden;
import com.examenfinal.ms_ordenes.repository.OrdenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdenService {

    private final OrdenRepository ordenRepository;

    public Orden crear(Orden orden) {
        orden.setFecha(LocalDateTime.now());
        return ordenRepository.save(orden);
    }

    public List<Orden> listar() {
        return ordenRepository.findAll();
    }
}
