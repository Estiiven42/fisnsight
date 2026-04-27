package com.finsight.autenticacion.controladores;

import com.finsight.autenticacion.dto.PeticionLogin;
import com.finsight.autenticacion.dto.PeticionRegistro;
import com.finsight.autenticacion.dto.RespuestaToken;
import com.finsight.autenticacion.servicios.ServicioAutenticacion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class ControladorAutenticacion {

    private final ServicioAutenticacion servicioAutenticacion;

    public ControladorAutenticacion(ServicioAutenticacion servicioAutenticacion) {
        this.servicioAutenticacion = servicioAutenticacion;
    }

    @PostMapping("/registrar")
    public ResponseEntity<RespuestaToken> registrar(@RequestBody PeticionRegistro peticion) {
        return ResponseEntity.ok(servicioAutenticacion.registrar(peticion));
    }

    @PostMapping("/login")
    public ResponseEntity<RespuestaToken> login(@RequestBody PeticionLogin peticion) {
        return ResponseEntity.ok(servicioAutenticacion.login(peticion));
    }
}
