package com.finsight.autenticacion.dto;

public class PeticionLogin {

    private String correo;
    private String contrasena;

    public String getCorreo() { return correo; }
    public String getContrasena() { return contrasena; }

    public void setCorreo(String correo) { this.correo = correo; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}
