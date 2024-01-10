package com.mst.app.services.router;

import com.mst.app.persistence.entities.Router;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RouterService {
    public Iterable<Router> findAll();

    public Page<Router> findAll(Pageable pageable);

    public Optional<Router> findById(Long id);

    public Router save(Router router);

    public void deleteById(Long id);
}
