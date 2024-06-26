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
    @Column(name = "id_antena")
    private Long idAntena;

    private String ip;

    private String mac;

    public Long getIdAntena() {
        return idAntena;
    }

    public void setIdAntena(Long idAntena) {
        this.idAntena = idAntena;
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
