package com.mst.app.services.cortes;


import com.mst.app.entity.Corte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CorteService {
    public Iterable<Corte> findAll();

    public Page<Corte> findAll(Pageable pageable);

    public Optional<Corte> findById(Long id);

    public Corte save(Corte corte);

    public void deleteById(Long id);
}
