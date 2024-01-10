package com.mst.app.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "routers")
public class Router {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_router;
    private String ip;
    private String mac;

    public Long getId_router() {
        return id_router;
    }

    public void setId_router(Long id_router) {
        this.id_router = id_router;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
