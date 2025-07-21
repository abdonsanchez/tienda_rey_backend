package com.example.tienda_rey.repository;

import com.example.tienda_rey.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}
