package com.example.tienda_rey.service;

import com.example.tienda_rey.model.Articulo;

import java.util.List;
import java.util.Optional;

public interface ArticuloService {
    Articulo crearArticulo(Articulo articulo);
    List<Articulo> obtenerTodos();
    Optional<Articulo> obtenerPorId(Long id);
    Articulo actualizarArticulo(Long id, Articulo articuloActualizado);
    void eliminarArticulo(Long id);
}
