package com.mst.app.controllers;

import com.mst.app.entity.Corte;
import com.mst.app.services.cortes.CorteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/cortes")
public class CorteController {
    @Autowired
    private CorteService corteService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Corte corte) {
        return ResponseEntity.status(HttpStatus.CREATED).body(corteService.save(corte));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
        Optional<Corte> corte = corteService.findById(id);

        if(!corte.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(corte);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Corte corteInfo, @PathVariable(value = "id") Long id) {
        Optional<Corte> corte = corteService.findById(id);

        if(!corte.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        corte.get().setLimite(corteInfo.getLimite());
        corte.get().setTolerancia(corteInfo.getTolerancia());
        corte.get().setEstatus(corteInfo.getEstatus());

        return ResponseEntity.status(HttpStatus.CREATED).body(corteService.save(corte.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if(!corteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        corteService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Corte> readAll() {
        List<Corte> cortes = StreamSupport
                .stream(corteService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return cortes;
    }
}
