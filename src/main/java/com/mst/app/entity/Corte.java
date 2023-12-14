package com.mst.app.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "cortes")
public class Corte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_corte;
    private Integer limite;
    private Integer tolerancia;
    private String estatus;

    public Long getId_corte() {
        return id_corte;
    }

    public void setId_corte(Long id_corte) {
        this.id_corte = id_corte;
    }

    public Integer getLimite() { return limite; }

    public void setLimite(Integer limite) { this.limite = limite; }

    public Integer getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(Integer tolerancia) {
        this.tolerancia = tolerancia;
    }

    public String getEstatus() { return estatus; }

    public void setEstatus(String estatus) { this.estatus = estatus; }
}
