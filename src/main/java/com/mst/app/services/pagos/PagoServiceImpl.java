package com.mst.app.services.pagos;

import com.mst.app.persistence.entities.Pago;
import com.mst.app.persistence.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pago> findAll() {
        return pagoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Pago> findAll(Pageable pageable) {
        return pagoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pago> findById(Long id) {
        return pagoRepository.findById(id);
    }

    @Override
    @Transactional
    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    @Transactional
    public void deleteById(Long id) { pagoRepository.deleteById(id); }
}
