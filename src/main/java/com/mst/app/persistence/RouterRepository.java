package com.mst.app.persistence;

import com.mst.app.persistence.entities.Router;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouterRepository extends JpaRepository<Router, Long> {}