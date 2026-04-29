package com.finsight.autenticacion.seguridad;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FiltroJwt extends OncePerRequestFilter {

    private final ServicioJwt servicioJwt;

    public FiltroJwt(ServicioJwt servicioJwt) {
        this.servicioJwt = servicioJwt;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            if (servicioJwt.esTokenValido(token)) {
                String correo = servicioJwt.extraerCorreo(token);
                System.out.println("Usuario autenticado: " + correo);
            }
        }

        filterChain.doFilter(request, response);
    }
}