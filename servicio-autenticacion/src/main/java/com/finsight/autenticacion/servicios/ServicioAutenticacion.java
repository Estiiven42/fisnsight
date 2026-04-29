package com.finsight.autenticacion.servicios;

import com.finsight.autenticacion.dto.PeticionLogin;
import com.finsight.autenticacion.dto.PeticionRegistro;
import com.finsight.autenticacion.dto.RespuestaToken;
import com.finsight.autenticacion.modelos.Usuario;
import com.finsight.autenticacion.repositorios.UsuarioRepository;
import com.finsight.autenticacion.seguridad.ServicioJwt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServicioAutenticacion {

    private final UsuarioRepository repositorioUsuario;
    private final ServicioJwt servicioJwt;
    private final BCryptPasswordEncoder codificador = new BCryptPasswordEncoder(12);

    public ServicioAutenticacion(UsuarioRepository repositorioUsuario,
                                  ServicioJwt servicioJwt) {
        this.repositorioUsuario = repositorioUsuario;
        this.servicioJwt = servicioJwt;
    }

    public RespuestaToken registrar(PeticionRegistro peticion) {
    if (repositorioUsuario.existsByCorreo(peticion.getCorreo())) {
        throw new RuntimeException("El correo ya esta registrado");
    }

    Usuario usuario = new Usuario();
    usuario.setNombre(peticion.getNombre());
    usuario.setCorreo(peticion.getCorreo());
    usuario.setContrasenaHash(codificador.encode(peticion.getContrasena()));

    usuario = repositorioUsuario.save(usuario); // 🔥 IMPORTANTE

    String token = servicioJwt.generarToken(usuario.getCorreo());

    return new RespuestaToken(
            token,
            usuario.getId().toString(),
            usuario.getNombre()
    );
}

    public RespuestaToken login(PeticionLogin peticion) {
        Usuario usuario = repositorioUsuario.findByCorreo(peticion.getCorreo())
                .orElseThrow(() -> new RuntimeException("Credenciales incorrectas"));

        if (!codificador.matches(peticion.getContrasena(), usuario.getContrasenaHash())) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        String token = servicioJwt.generarToken(usuario.getCorreo());

        return new RespuestaToken(
                token,
                usuario.getId().toString(), // 🔥 FIX AQUÍ
                usuario.getNombre()
        );
    }
}