package com.mst.app.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "antenas")
@NoArgsConstructor
public class Antena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_antena;

    private String ip;

    private String mac;
}
