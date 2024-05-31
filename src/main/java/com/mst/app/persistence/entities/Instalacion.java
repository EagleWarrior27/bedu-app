package com.mst.app.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "instalaciones")
@NoArgsConstructor
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
}
