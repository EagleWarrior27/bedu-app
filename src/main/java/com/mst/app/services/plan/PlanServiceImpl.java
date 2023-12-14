package com.mst.app.services.plan;

import com.mst.app.entity.Plan;
import com.mst.app.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanRepository planRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Plan> findAll() {
        return planRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Plan> findAll(Pageable pageable) {
        return planRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Plan> findById(Long id) {
        return planRepository.findById(id);
    }

    @Override
    @Transactional
    public Plan save(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    @Transactional
    public void deleteById(Long id) { planRepository.deleteById(id); }
}
