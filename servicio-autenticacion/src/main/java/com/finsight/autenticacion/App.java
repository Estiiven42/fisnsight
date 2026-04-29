package com.finsight.autenticacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.finsight.autenticacion")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
