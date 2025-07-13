package com.examenfinal.ms_ordenes.controller;

import com.examenfinal.ms_ordenes.entity.Orden;
import com.examenfinal.ms_ordenes.service.OrdenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
@RequiredArgsConstructor
public class OrdenController {

    private final OrdenService ordenService;

    @PostMapping
    public Orden crear(@RequestBody Orden orden) {
        return ordenService.crear(orden);
    }

    @GetMapping
    public List<Orden> listar() {
        return ordenService.listar();
    }
}
