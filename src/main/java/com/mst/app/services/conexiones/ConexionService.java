package com.mst.app.services.conexiones;

import com.mst.app.persistence.entities.Conexion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ConexionService {
    public Iterable<Conexion> findAll();

    public Page<Conexion> findAll(Pageable pageable);

    public Optional<Conexion> findById(Long id);

    public Conexion save(Conexion conexion);

    public void deleteById(Long id);
}
