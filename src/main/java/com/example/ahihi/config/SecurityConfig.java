package com.example.ahihi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    String[] patternsPublic = {
            "/", "/account/register",
            "/css/**", "/js/**", "/bootstrap/**", "/images/**",
            "/error"
    };

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(author -> author.requestMatchers(patternsPublic).permitAll()
                .anyRequest().permitAll())
                .oauth2Login(oauth2 -> oauth2.loginPage("/account/login").permitAll()
                        .defaultSuccessUrl("/"))
                .logout(logout -> logout.permitAll())
                // .csrf(csrf -> csrf.disable())
                .build();
    }
}
