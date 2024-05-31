package com.mst.app.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "conexiones")
@NoArgsConstructor
public class Conexion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conexion;

    private Long id_usuario;

    private Long id_instalacion;
}
