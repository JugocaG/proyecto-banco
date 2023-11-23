package com.unisabana.proyectobanco.configuration;


import com.unisabana.proyectobanco.dto.SignupDTO;
import com.unisabana.proyectobanco.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}
