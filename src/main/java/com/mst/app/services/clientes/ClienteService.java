package com.mst.app.services.clientes;

import com.mst.app.persistence.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClienteService {
    public Iterable<Cliente> findAll();

    public Page<Cliente> findAll(Pageable pageable);

    public Optional<Cliente> findById(Long id);

    public Cliente save(Cliente cliente);

    public void deleteById(Long id);
}
