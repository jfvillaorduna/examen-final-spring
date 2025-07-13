package com.examenfinal.ms_ordenes.repository;

import com.examenfinal.ms_ordenes.entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
}
