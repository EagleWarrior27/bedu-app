package com.mst.app.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuarios")
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(length = 90)
    private String nombre;

    @Column(name="correo", nullable = false, length = 60, unique = true)
    private String correo;

    private String password;

    private String avatar;
}
