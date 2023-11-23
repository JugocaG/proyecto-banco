package com.unisabana.proyectobanco.bd;

import com.unisabana.proyectobanco.vo.RolesEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class Usuario {
    @Id
    private int id;

    private RolesEnum rol;

    private String username;

    private String email;

    private String password;




}
