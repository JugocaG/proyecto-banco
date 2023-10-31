package com.unisabana.proyectobanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class ProyectoBancoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoBancoApplication.class, args);
    }

}
