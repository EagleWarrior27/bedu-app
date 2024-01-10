package com.mst.app.services.plan;

import com.mst.app.persistence.entities.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PlanService {
    public Iterable<Plan> findAll();

    public Page<Plan> findAll(Pageable pageable);

    public Optional<Plan> findById(Long id);

    public Plan save(Plan plan);

    public void deleteById(Long id);
}
