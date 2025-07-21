package com.example.tienda_rey.service;

import com.example.tienda_rey.model.Articulo;
import com.example.tienda_rey.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public Articulo crearArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    public List<Articulo> obtenerTodos() {
        return articuloRepository.findAll();
    }

    @Override
    public Optional<Articulo> obtenerPorId(Long id) {
        return articuloRepository.findById(id);
    }

    @Override
    public Articulo actualizarArticulo(Long id, Articulo articuloActualizado) {
        return articuloRepository.findById(id).map(articulo -> {
            articulo.setNombre(articuloActualizado.getNombre());
            articulo.setPrecio(articuloActualizado.getPrecio());
            return articuloRepository.save(articulo);
        }).orElseThrow(() -> new RuntimeException("Artículo no encontrado con ID: " + id));
    }

    @Override
    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(id);
    }
}
