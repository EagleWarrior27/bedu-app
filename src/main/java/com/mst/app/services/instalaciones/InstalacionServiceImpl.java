package com.mst.app.services.instalaciones;

import com.mst.app.entity.Instalacion;
import com.mst.app.repository.InstalacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class InstalacionServiceImpl implements InstalacionService{
    @Autowired
    private InstalacionRepository instalacionRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Instalacion> findAll() {
        return instalacionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Instalacion> findAll(Pageable pageable) {
        return instalacionRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Instalacion> findById(Long id) {
        return instalacionRepository.findById(id);
    }

    @Override
    @Transactional
    public Instalacion save(Instalacion instalacion) {
        return instalacionRepository.save(instalacion);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        instalacionRepository.deleteById(id);
    }
}
