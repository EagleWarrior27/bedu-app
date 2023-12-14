package com.mst.app.controllers;

import com.mst.app.entity.Instalacion;
import com.mst.app.services.instalaciones.InstalacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/instalaciones")
public class InstalacionController {
    @Autowired
    private InstalacionService instalacionService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Instalacion instalacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(instalacionService.save(instalacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
        Optional<Instalacion> instalacion = instalacionService.findById(id);

        if(!instalacion.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(instalacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Instalacion instalacionInfo, @PathVariable(value = "id") Long id) {
        Optional<Instalacion> instalacion = instalacionService.findById(id);

        if(!instalacion.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        instalacion.get().setTipo(instalacionInfo.getTipo());
        instalacion.get().setId_antena(instalacionInfo.getId_antena());
        instalacion.get().setId_router(instalacionInfo.getId_router());
        instalacion.get().setId_plan(instalacionInfo.getId_plan());
        instalacion.get().setId_corte(instalacionInfo.getId_corte());
        instalacion.get().setFecha(instalacionInfo.getFecha());
        instalacion.get().setLatitud(instalacionInfo.getLatitud());
        instalacion.get().setLongitud(instalacionInfo.getLongitud());

        return ResponseEntity.status(HttpStatus.CREATED).body(instalacionService.save(instalacion.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if(!instalacionService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        instalacionService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Instalacion> readAll() {
        List<Instalacion> usuarios = StreamSupport
                .stream(instalacionService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return usuarios;
    }
}
