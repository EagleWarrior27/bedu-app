package com.mst.app.controllers;

import com.mst.app.persistence.entities.Antena;
import com.mst.app.services.antenas.AntenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/antenas")
public class AntenaController {
    @Autowired
    private AntenaService antenaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Antena antena) {
        return ResponseEntity.status(HttpStatus.CREATED).body(antenaService.save(antena));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
        Optional<Antena> antena = antenaService.findById(id);

        if(!antena.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(antena);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Antena antenaInfo, @PathVariable(value = "id") Long id) {
        Optional<Antena> antena = antenaService.findById(id);

        if(!antena.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        antena.get().setIp(antenaInfo.getIp());
        antena.get().setMac(antenaInfo.getMac());

        return ResponseEntity.status(HttpStatus.CREATED).body(antenaService.save(antena.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if(!antenaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        antenaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Antena> readAll() {
        List<Antena> antenas = StreamSupport
                .stream(antenaService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return antenas;
    }
}
