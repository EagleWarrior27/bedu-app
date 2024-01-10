package com.mst.app.controllers;

import com.mst.app.persistence.entities.Usuario;
import com.mst.app.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
        Optional<Usuario> usuario = usuarioService.findById(id);

        if(!usuario.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Usuario usuarioInfo, @PathVariable(value = "id") Long id) {
        Optional<Usuario> usuario = usuarioService.findById(id);

        if(!usuario.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        usuario.get().setNombre(usuarioInfo.getNombre());
        usuario.get().setCorreo(usuarioInfo.getCorreo());
        usuario.get().setPassword(usuarioInfo.getPassword());
        usuario.get().setAvatar(usuarioInfo.getAvatar());

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if(!usuarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        usuarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Usuario> readAll() {
        List<Usuario> usuarios = StreamSupport
                .stream(usuarioService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return usuarios;
    }
}
