package com.pixelpulse.ejercicio02ec02.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.withUsername("anthony")
                .password(passwordEncoder.encode("a123"))
                .roles("ADMIN")
                .build();
 
        UserDetails user = User.withUsername("walter")
                .password(passwordEncoder.encode("w123"))
                .roles("USER")
                .build();
              
        return new InMemoryUserDetailsManager(admin, user);
    }
 
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    	http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(authz -> authz
	            .requestMatchers("/api/listar_public").permitAll() // Primero
	            .requestMatchers("/api/listar_admin").hasRole("ADMIN")
	            .requestMatchers("/api/listar_user").hasRole("USER")
	            .anyRequest().authenticated()
	        )
	        .httpBasic(Customizer.withDefaults());
	
	    return http.build();
    }
 
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
