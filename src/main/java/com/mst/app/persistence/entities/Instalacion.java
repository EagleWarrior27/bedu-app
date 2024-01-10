package com.mst.app.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "instalaciones")
public class Instalacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_instalacion;
    private String tipo;
    private Long id_antena;
    private Long id_router;
    private Long id_plan;
    private Long id_corte;
    private String fecha;
    private String latitud;
    private String longitud;

    public Long getId_instalacion() {
        return id_instalacion;
    }

    public void setId_instalacion(Long id_instalacion) {
        this.id_instalacion = id_instalacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getId_antena() {
        return id_antena;
    }

    public void setId_antena(Long id_antena) {
        this.id_antena = id_antena;
    }

    public Long getId_router() {
        return id_router;
    }

    public void setId_router(Long id_router) {
        this.id_router = id_router;
    }

    public Long getId_plan() {
        return id_plan;
    }

    public void setId_plan(Long id_plan) {
        this.id_plan = id_plan;
    }

    public Long getId_corte() {
        return id_corte;
    }

    public void setId_corte(Long id_corte) {
        this.id_corte = id_corte;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
