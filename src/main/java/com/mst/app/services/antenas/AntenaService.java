package com.mst.app.services.antenas;

import com.mst.app.entity.Antena;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AntenaService {
    public Iterable<Antena> findAll();

    public Page<Antena> findAll(Pageable pageable);

    public Optional<Antena> findById(Long id);

    public Antena save(Antena antena);

    public void deleteById(Long id);
}
