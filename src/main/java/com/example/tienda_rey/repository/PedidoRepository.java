package com.example.tienda_rey.repository;

import com.example.tienda_rey.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
