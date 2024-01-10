package com.mst.app.persistence;

import com.mst.app.persistence.entities.Instalacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstalacionRepository extends JpaRepository<Instalacion, Long> {}