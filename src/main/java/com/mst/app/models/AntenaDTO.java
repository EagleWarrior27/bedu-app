package com.mst.app.models;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
@Builder
public class AntenaDTO {
    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    private Long idAntena;

    @NotBlank(message = "Se debe proporcionar una dirección IP")
    private String ip;

    @NotBlank(message = "Se debe proporcionar una dirección MAC")
    private String mac;

    public AntenaDTO() { }

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
