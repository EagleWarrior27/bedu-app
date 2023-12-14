package com.mst.app.repository;

import com.mst.app.entity.Antena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntenaRepository extends JpaRepository<Antena, Long> {}