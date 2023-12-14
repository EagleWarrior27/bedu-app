package com.mst.app.controllers;

import com.mst.app.entity.Direccion;
import com.mst.app.services.direcciones.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {
    @Autowired
    private DireccionService direccionService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Direccion direccion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(direccionService.save(direccion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
        Optional<Direccion> direccion = direccionService.findById(id);

        if(!direccion.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(direccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Direccion direccionInfo, @PathVariable(value = "id") Long id) {
        Optional<Direccion> direccion = direccionService.findById(id);

        if(!direccion.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        direccion.get().setCalle(direccionInfo.getCalle());
        direccion.get().setNumero(direccionInfo.getNumero());
        direccion.get().setFraccionamiento(direccionInfo.getFraccionamiento());
        direccion.get().setReferencia(direccionInfo.getReferencia());

        return ResponseEntity.status(HttpStatus.CREATED).body(direccionService.save(direccion.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if(!direccionService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        direccionService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Direccion> readAll() {
        List<Direccion> direcciones = StreamSupport
                .stream(direccionService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return direcciones;
    }
}
