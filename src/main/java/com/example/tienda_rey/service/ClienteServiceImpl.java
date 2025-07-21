package com.example.tienda_rey.service;

import com.example.tienda_rey.model.Cliente;
import com.example.tienda_rey.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> obtenerPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    @Override
    public Optional<Cliente> obtenerPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente cliente) {
        return clienteRepository.findById(id).map(existingCliente -> {
            existingCliente.setNombre(cliente.getNombre());
            existingCliente.setEmail(cliente.getEmail());
            // actualizar otros campos si hay
            return clienteRepository.save(existingCliente);
        }).orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    @Override
    public void eliminarCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
        clienteRepository.deleteById(id);
    }

}
