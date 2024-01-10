package com.mst.app.controllers;

import com.mst.app.persistence.entities.Cliente;
import com.mst.app.services.clientes.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
        Optional<Cliente> cliente = clienteService.findById(id);

        if(!cliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Cliente clienteInfo, @PathVariable(value = "id") Long id) {
        Optional<Cliente> cliente = clienteService.findById(id);

        if(!cliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        cliente.get().setNombre(clienteInfo.getNombre());
        cliente.get().setCelular(clienteInfo.getCelular());
        cliente.get().setId_direccion(clienteInfo.getId_direccion());
        cliente.get().setCorreo(clienteInfo.getCorreo());
        cliente.get().setEstatus(clienteInfo.getEstatus());

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if(!clienteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        clienteService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Cliente> readAll() {
        List<Cliente> clientes = StreamSupport
                .stream(clienteService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return clientes;
    }
}
