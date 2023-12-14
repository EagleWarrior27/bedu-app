package com.mst.app.controllers;

import com.mst.app.entity.Router;
import com.mst.app.services.router.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/routers")
public class RouterController {
    @Autowired
    private RouterService routerService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Router router) {
        return ResponseEntity.status(HttpStatus.CREATED).body(routerService.save(router));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
        Optional<Router> plan = routerService.findById(id);

        if(!plan.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(plan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Router routerInfo, @PathVariable(value = "id") Long id) {
        Optional<Router> router = routerService.findById(id);

        if(!router.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        router.get().setIp(routerInfo.getIp());
        router.get().setMac(routerInfo.getMac());

        return ResponseEntity.status(HttpStatus.CREATED).body(routerService.save(router.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if(!routerService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        routerService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Router> readAll() {
        List<Router> routers = StreamSupport
                .stream(routerService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return routers;
    }
}
