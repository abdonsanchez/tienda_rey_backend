package com.example.tienda_rey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("pedido") // Ignorar referencia inversa para no recursar
    private List<PedidoArticulo> pedidoArticulos;

    public Pedido() {}

    public Pedido(Date fecha, Cliente cliente, List<PedidoArticulo> pedidoArticulos) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.pedidoArticulos = pedidoArticulos;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<PedidoArticulo> getPedidoArticulos() {
        return pedidoArticulos;
    }

    public void setPedidoArticulos(List<PedidoArticulo> pedidoArticulos) {
        this.pedidoArticulos = pedidoArticulos;
    }
}
