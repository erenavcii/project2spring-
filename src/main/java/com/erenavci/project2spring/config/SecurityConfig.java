package com.erenavci.project2spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // CSRF korumasını kapat
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll() // H2 console'a izin ver
                .anyRequest().authenticated() // Diğer isteklere login zorunlu
            )
            .headers(headers -> headers.frameOptions(frame -> frame.disable())) // H2 console için frame izni
            .formLogin(Customizer.withDefaults()); // login formu aktif

        return http.build();
    }
}
