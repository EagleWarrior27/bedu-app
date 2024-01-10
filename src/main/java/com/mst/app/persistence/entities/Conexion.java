package com.mst.app.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "conexiones")
public class Conexion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conexion;
    private Long id_usuario;
    private Long id_instalacion;

    public Long getId_conexion() {
        return id_conexion;
    }

    public void setId_conexion(Long id_conexion) {
        this.id_conexion = id_conexion;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_instalacion() {
        return id_instalacion;
    }

    public void setId_instalacion(Long id_instalacion) {
        this.id_instalacion = id_instalacion;
    }
}
