package com.mst.app.controllers;

import com.mst.app.entity.Conexion;
import com.mst.app.services.conexiones.ConexionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/conexiones")
public class ConexionController {
    @Autowired
    private ConexionService conexionService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Conexion conexion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(conexionService.save(conexion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
        Optional<Conexion> conexion = conexionService.findById(id);

        if(!conexion.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(conexion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Conexion conexionInfo, @PathVariable(value = "id") Long id) {
        Optional<Conexion> conexion = conexionService.findById(id);

        if(!conexion.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        conexion.get().setId_usuario(conexionInfo.getId_usuario());
        conexion.get().setId_instalacion(conexionInfo.getId_instalacion());

        return ResponseEntity.status(HttpStatus.CREATED).body(conexionService.save(conexion.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if(!conexionService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        conexionService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Conexion> readAll() {
        List<Conexion> conexiones = StreamSupport
                .stream(conexionService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return conexiones;
    }
}
