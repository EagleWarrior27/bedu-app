package com.mst.app.services.router;

import com.mst.app.persistence.entities.Router;
import com.mst.app.persistence.RouterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RouterServiceImpl implements RouterService {
    @Autowired
    private RouterRepository routerRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Router> findAll() {
        return routerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Router> findAll(Pageable pageable) {
        return routerRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Router> findById(Long id) {
        return routerRepository.findById(id);
    }

    @Override
    @Transactional
    public Router save(Router router) {
        return routerRepository.save(router);
    }

    @Override
    @Transactional
    public void deleteById(Long id) { routerRepository.deleteById(id); }
}
