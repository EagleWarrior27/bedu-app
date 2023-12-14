package com.mst.app.controllers;

import com.mst.app.entity.Pago;
import com.mst.app.services.pagos.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/pagos")
public class PagoController {
    @Autowired
    private PagoService pagoService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pago pago) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.save(pago));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
        Optional<Pago> pago = pagoService.findById(id);

        if(!pago.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Pago pagoInfo, @PathVariable(value = "id") Long id) {
        Optional<Pago> pago = pagoService.findById(id);

        if(!pago.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        pago.get().setTipo(pagoInfo.getTipo());
        pago.get().setReferencia(pagoInfo.getReferencia());
        pago.get().setImporte(pagoInfo.getImporte());

        return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.save(pago.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if(!pagoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        pagoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Pago> readAll() {
        List<Pago> pagos = StreamSupport
                .stream(pagoService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return pagos;
    }
}
