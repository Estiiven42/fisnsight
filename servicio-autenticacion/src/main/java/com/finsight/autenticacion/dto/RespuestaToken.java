package com.finsight.autenticacion.dto;

public class RespuestaToken {
    private String token;
    private String usuarioId;
    private String nombre;

    public RespuestaToken(String token, String usuarioId, String nombre) {
        this.token = token;
        this.usuarioId = usuarioId;
        this.nombre = nombre;
    }

    public String getToken() { return token; }
    public String getUsuarioId() { return usuarioId; }
    public String getNombre() { return nombre; }
}
