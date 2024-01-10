package com.mst.app.services.antenas;

import com.mst.app.persistence.entities.Antena;
import com.mst.app.persistence.AntenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AntenaServiceImpl implements AntenaService{
    @Autowired
    private AntenaRepository antenaRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Antena> findAll() {
        return antenaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Antena> findAll(Pageable pageable) {
        return antenaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Antena> findById(Long id) {
        return antenaRepository.findById(id);
    }

    @Override
    @Transactional
    public Antena save(Antena cliente) {
        return antenaRepository.save(cliente);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        antenaRepository.deleteById(id);
    }
}
