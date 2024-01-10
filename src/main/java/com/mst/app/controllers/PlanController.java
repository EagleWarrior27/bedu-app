package com.mst.app.controllers;

import com.mst.app.persistence.entities.Plan;
import com.mst.app.services.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/planes")
public class PlanController {
    @Autowired
    private PlanService planService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Plan plan) {
        return ResponseEntity.status(HttpStatus.CREATED).body(planService.save(plan));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
        Optional<Plan> plan = planService.findById(id);

        if(!plan.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(plan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Plan planInfo, @PathVariable(value = "id") Long id) {
        Optional<Plan> plan = planService.findById(id);

        if(!plan.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        plan.get().setCapacidad(planInfo.getCapacidad());

        return ResponseEntity.status(HttpStatus.CREATED).body(planService.save(plan.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if(!planService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        planService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Plan> readAll() {
        List<Plan> planes = StreamSupport
                .stream(planService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return planes;
    }
}
