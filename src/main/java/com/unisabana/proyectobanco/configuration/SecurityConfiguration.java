package com.unisabana.proyectobanco.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

    String administrador = "ADMINISTRADOR";
    String usuario = "USUARIO";
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.builder()
                .username("juan")
                .password(encoder().encode("ProyectoBanco#1234"))
                .roles(administrador, usuario)
                .build();
        UserDetails user2 = User.builder()
                .username("sebastian")
                .password(encoder().encode("ProyectoBanco#4321"))
                .roles(usuario)
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests(authz -> authz
                        .antMatchers("/api/cliente/**").hasRole(administrador)
                        .antMatchers("/api/cuenta/**").hasRole(administrador)
                        .antMatchers("/api/transaccion/**").hasRole(usuario)
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }


}