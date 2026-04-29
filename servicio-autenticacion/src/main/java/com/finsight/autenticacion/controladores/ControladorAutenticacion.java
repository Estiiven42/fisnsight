package com.finsight.autenticacion.controladores;

import com.finsight.autenticacion.dto.PeticionLogin;
import com.finsight.autenticacion.dto.PeticionRegistro;
import com.finsight.autenticacion.dto.RespuestaToken;
import com.finsight.autenticacion.servicios.ServicioAutenticacion;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth") // 🔥 ESTO ES CLAVE
public class ControladorAutenticacion {

    private final ServicioAutenticacion servicio;

    public ControladorAutenticacion(ServicioAutenticacion servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/registro")
    public RespuestaToken registrar(@RequestBody PeticionRegistro peticion) {
        return servicio.registrar(peticion);
    }

    @PostMapping("/login")
    public RespuestaToken login(@RequestBody PeticionLogin peticion) {
        return servicio.login(peticion);
    }
}