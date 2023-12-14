package com.mst.app.services.direcciones;


import com.mst.app.entity.Direccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DireccionService {
    public Iterable<Direccion> findAll();

    public Page<Direccion> findAll(Pageable pageable);

    public Optional<Direccion> findById(Long id);

    public Direccion save(Direccion direccion);

    public void deleteById(Long id);
}
