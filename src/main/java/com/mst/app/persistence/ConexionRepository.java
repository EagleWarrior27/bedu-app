package com.mst.app.persistence;

import com.mst.app.persistence.entities.Conexion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConexionRepository extends JpaRepository<Conexion, Long> {}