package com.mst.app.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "routers")
@NoArgsConstructor
public class Router {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_router;

    private String ip;

    private String mac;
}
