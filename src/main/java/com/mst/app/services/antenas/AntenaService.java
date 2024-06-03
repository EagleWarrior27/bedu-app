package com.mst.app.services.antenas;

import com.mst.app.models.AntenaDTO;

import java.util.Optional;

public interface AntenaService {
    Iterable<AntenaDTO> findAll();

    Optional<AntenaDTO> findById(Long id);

    AntenaDTO save(AntenaDTO antena);

    void deleteById(Long id);
}
