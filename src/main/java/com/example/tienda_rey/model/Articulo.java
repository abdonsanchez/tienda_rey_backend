package com.example.tienda_rey.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "articulo")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private double precio;

    @OneToMany(mappedBy = "articulo")
    @JsonIgnore
    private List<PedidoArticulo> pedidoArticulos;

    public Articulo() {}

    public Articulo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<PedidoArticulo> getPedidoArticulos() {
        return pedidoArticulos;
    }

    public void setPedidoArticulos(List<PedidoArticulo> pedidoArticulos) {
        this.pedidoArticulos = pedidoArticulos;
    }
}
