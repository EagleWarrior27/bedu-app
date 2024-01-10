package com.mst.app.services.conexiones;

import com.mst.app.persistence.entities.Conexion;
import com.mst.app.persistence.ConexionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ConexionServiceImpl implements ConexionService {
    @Autowired
    private ConexionRepository conexionRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Conexion> findAll() {
        return conexionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Conexion> findAll(Pageable pageable) {
        return conexionRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Conexion> findById(Long id) {
        return conexionRepository.findById(id);
    }

    @Override
    @Transactional
    public Conexion save(Conexion conexion) {
        return conexionRepository.save(conexion);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        conexionRepository.deleteById(id);
    }
}