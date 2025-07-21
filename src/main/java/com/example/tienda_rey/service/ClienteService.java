package com.example.tienda_rey.service;

import com.example.tienda_rey.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Cliente crearCliente(Cliente cliente);
    Optional<Cliente> obtenerPorEmail(String email);
    Optional<Cliente> obtenerPorId(Long id);
    List<Cliente> listarClientes();
    Cliente actualizarCliente(Long id, Cliente cliente);
    void eliminarCliente(Long id);

}
