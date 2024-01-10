package com.mst.app.services.direcciones;

import com.mst.app.persistence.entities.Direccion;
import com.mst.app.persistence.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Direccion> findAll() {
        return direccionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Direccion> findAll(Pageable pageable) {
        return direccionRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Direccion> findById(Long id) {
        return direccionRepository.findById(id);
    }

    @Override
    @Transactional
    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        direccionRepository.deleteById(id);
    }
}
