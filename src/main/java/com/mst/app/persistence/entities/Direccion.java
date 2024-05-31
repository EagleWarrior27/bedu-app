package com.mst.app.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "direcciones")
@NoArgsConstructor
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_direccion;

    private String calle;

    private String numero;

    private String fraccionamiento;

    private String referencia;
}
