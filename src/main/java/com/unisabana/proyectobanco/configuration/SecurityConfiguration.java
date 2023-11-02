package com.unisabana.proyectobanco.configuration;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated();
//    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("juan")
//                .password("1234")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.authorizeHttpRequests((authz)->authz
//                .antMatchers("/api")
//                .authenticated()
//                )
//                .httpBasic();
//
//        return httpSecurity.build();
//
//
//    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.builder()
                .username("juan")
                .password(encoder().encode("1234"))
                .roles("ADMINISTRADOR", "USUARIO")
                .build();
        UserDetails user2 = User.builder()
                .username("sebastian")
                .password(encoder().encode("1234"))
                .roles("USUARIO")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests((authz) -> authz
                        .antMatchers("/api/cliente/**").hasRole("ADMINISTRADOR")
                        .antMatchers("/api/cuenta/**").hasRole("ADMINISTRADOR")
                        .antMatchers("/api/transaccion/**").hasRole("USUARIO")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }


}