package com.example.tienda_rey.service;

import com.example.tienda_rey.model.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido crearPedido(Pedido pedido);
    List<Pedido> listarPedidos();
    Pedido obtenerPedidoPorId(Long id);
}
