package com.example.tienda_rey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "pedido_articulo")
public class PedidoArticulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonIgnoreProperties("pedidoArticulos") // Ignorar referencia inversa para no recursar
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;

    public PedidoArticulo() {}

    public PedidoArticulo(int cantidad, Pedido pedido, Articulo articulo) {
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.articulo = articulo;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
