package com.example.tienda_rey.repository;

import com.example.tienda_rey.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email); // útil para evitar duplicados
}
