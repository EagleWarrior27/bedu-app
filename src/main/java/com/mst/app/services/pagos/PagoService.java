package com.mst.app.services.pagos;

import com.mst.app.persistence.entities.Pago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PagoService {
    public Iterable<Pago> findAll();

    public Page<Pago> findAll(Pageable pageable);

    public Optional<Pago> findById(Long id);

    public Pago save(Pago pago);

    public void deleteById(Long id);
}
