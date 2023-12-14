package com.mst.app.services.instalaciones;

import com.mst.app.entity.Instalacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface InstalacionService {
    public Iterable<Instalacion> findAll();

    public Page<Instalacion> findAll(Pageable pageable);

    public Optional<Instalacion> findById(Long id);

    public Instalacion save(Instalacion instalacion);

    public void deleteById(Long id);
}
