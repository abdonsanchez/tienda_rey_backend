package com.example.tienda_rey.controller;

import com.example.tienda_rey.model.Articulo;
import com.example.tienda_rey.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articulos")
@CrossOrigin(origins = "*") // Permitir acceso desde cualquier frontend
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @PostMapping
    public Articulo crearArticulo(@RequestBody Articulo articulo) {
        return articuloService.crearArticulo(articulo);
    }

    @GetMapping
    public List<Articulo> listarArticulos() {
        return articuloService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Articulo obtenerArticulo(@PathVariable Long id) {
        return articuloService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado con ID: " + id));
    }

    @PutMapping("/{id}")
    public Articulo actualizarArticulo(@PathVariable Long id, @RequestBody Articulo articulo) {
        return articuloService.actualizarArticulo(id, articulo);
    }

    @DeleteMapping("/{id}")
    public void eliminarArticulo(@PathVariable Long id) {
        articuloService.eliminarArticulo(id);
    }
}
