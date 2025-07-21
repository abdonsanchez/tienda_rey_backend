package com.example.tienda_rey.controller;

import com.example.tienda_rey.model.Cliente;
import com.example.tienda_rey.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente obtenerCliente(@PathVariable Long id) {
        return clienteService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    @GetMapping("/buscarPorEmail")
    public Cliente obtenerPorEmail(@RequestParam String email) {
        return clienteService.obtenerPorEmail(email)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con email: " + email));
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.actualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }

}
