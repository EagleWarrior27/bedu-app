package com.mst.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "antenas")
public class Antena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_antena;
    private String ip;
    private String mac;

    public Long getId_antena() {
        return id_antena;
    }

    public void setId_antena(Long id_antena) {
        this.id_antena = id_antena;
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
