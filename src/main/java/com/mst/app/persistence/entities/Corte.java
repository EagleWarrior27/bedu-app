package com.mst.app.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cortes")
@NoArgsConstructor
public class Corte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_corte;

    private Integer limite;

    private Integer tolerancia;

    private String estatus;
}
