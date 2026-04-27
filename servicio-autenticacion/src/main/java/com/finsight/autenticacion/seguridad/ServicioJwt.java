package com.finsight.autenticacion.seguridad;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class ServicioJwt {

    @Value("${jwt.secreto}")
    private String secreto;

    @Value("${jwt.expiracion-horas:24}")
    private int expiracionHoras;

    public String generarToken(String correo) {
        long ahora = System.currentTimeMillis();
        long expiracion = ahora + (expiracionHoras * 60L * 60L * 1000L);
        return Jwts.builder()
            .subject(correo)
            .issuedAt(new Date(ahora))
            .expiration(new Date(expiracion))
            .signWith(Keys.hmacShaKeyFor(secreto.getBytes(StandardCharsets.UTF_8)))
            .compact();
    }

    public String extraerCorreo(String token) {
        return Jwts.parser()
            .verifyWith(Keys.hmacShaKeyFor(secreto.getBytes(StandardCharsets.UTF_8)))
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }

    public boolean esTokenValido(String token) {
        try {
            extraerCorreo(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
