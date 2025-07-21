package com.example.tienda_rey.service;

import com.example.tienda_rey.model.Articulo;
import com.example.tienda_rey.model.Cliente;
import com.example.tienda_rey.model.Pedido;
import com.example.tienda_rey.model.PedidoArticulo;
import com.example.tienda_rey.repository.ArticuloRepository;
import com.example.tienda_rey.repository.ClienteRepository;
import com.example.tienda_rey.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public Pedido crearPedido(Pedido pedido) {
        // Validar cliente
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        pedido.setCliente(cliente);

        // Validar y asignar artículos en PedidoArticulo
        List<PedidoArticulo> pedidoArticulosValidados = pedido.getPedidoArticulos().stream()
                .map(pa -> {
                    Articulo articuloValido = articuloRepository.findById(pa.getArticulo().getId())
                            .orElseThrow(() -> new RuntimeException("Artículo no encontrado con ID: " + pa.getArticulo().getId()));
                    pa.setArticulo(articuloValido);
                    pa.setPedido(pedido);  // importante para la relación bidireccional
                    return pa;
                })
                .toList();

        pedido.setPedidoArticulos(pedidoArticulosValidados);

        // Setear la fecha actual antes de guardar
        pedido.setFecha(new Date());

        return pedidoRepository.save(pedido);
    }


    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
    }
}
