package com.mst.app.repository;

import com.mst.app.entity.Conexion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConexionRepository extends JpaRepository<Conexion, Long> {}