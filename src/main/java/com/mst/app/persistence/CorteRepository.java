package com.mst.app.persistence;

import com.mst.app.persistence.entities.Corte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorteRepository extends JpaRepository<Corte, Long> {}