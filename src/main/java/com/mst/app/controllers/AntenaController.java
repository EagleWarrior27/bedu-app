package com.mst.app.controllers;

import com.mst.app.models.AntenaDTO;
import com.mst.app.services.antenas.AntenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/antenas")
public class AntenaController {
    @Autowired
    private AntenaService antenaService;

    @GetMapping
    public ResponseEntity<?> readAll() {
        return ResponseEntity.ok(antenaService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AntenaDTO antena) {
        return ResponseEntity.status(HttpStatus.CREATED).body(antenaService.save(antena));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
        Optional<AntenaDTO> antena = antenaService.findById(id);

        if(!antena.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(antena);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody @Valid AntenaDTO antenaInfo) {
        Optional<AntenaDTO> antena = antenaService.findById(id);

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
}
