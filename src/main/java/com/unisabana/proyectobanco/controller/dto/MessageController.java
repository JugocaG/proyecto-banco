package com.unisabana.proyectobanco.controller.dto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GetMapping(value = ("message"))
    public String getMessage(){
        return "Hello";
    }
}
