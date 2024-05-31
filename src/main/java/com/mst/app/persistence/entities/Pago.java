package com.mst.app.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pagos")
@NoArgsConstructor
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pago;

    private Long id_instalacion;

    private String tipo;

    private Long referencia;

    private Double importe;
}
