package com.mst.app.services.cortes;

import com.mst.app.entity.Corte;
import com.mst.app.repository.CorteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CorteServiceImpl implements CorteService {
    @Autowired
    private CorteRepository corteRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Corte> findAll() {
        return corteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Corte> findAll(Pageable pageable) {
        return corteRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Corte> findById(Long id) {
        return corteRepository.findById(id);
    }

    @Override
    @Transactional
    public Corte save(Corte corte) {
        return corteRepository.save(corte);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        corteRepository.deleteById(id);
    }
}
