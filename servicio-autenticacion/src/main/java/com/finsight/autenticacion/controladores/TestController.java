package com.finsight.autenticacion.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "API de Autenticación activa";
    }

    @GetMapping("/test")
    public String test() {
        return "Servicio autenticacion funcionando";
    }
}