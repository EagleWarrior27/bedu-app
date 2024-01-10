package com.mst.app.persistence;

import com.mst.app.persistence.entities.Antena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntenaRepository extends JpaRepository<Antena, Long> {}