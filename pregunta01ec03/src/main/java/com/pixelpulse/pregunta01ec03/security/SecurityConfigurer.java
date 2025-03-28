package com.pixelpulse.pregunta01ec03.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pixelpulse.pregunta01ec03.filter.AuthFiltroToken;
import com.pixelpulse.pregunta01ec03.security.service.MiUserDetailsService;

    @Configuration
    public class SecurityConfigurer{
        private final MiUserDetailsService userDetailsService;
        private final AuthFiltroToken authFiltroToken;

        public SecurityConfigurer(MiUserDetailsService userDetailsService, AuthFiltroToken authFiltroToken) {
            this.userDetailsService = userDetailsService;
            this.authFiltroToken = authFiltroToken;
        }

        @Bean
        public BCryptPasswordEncoder passEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
            authProvider.setUserDetailsService(userDetailsService);
            authProvider.setPasswordEncoder(passEncoder());
            return authProvider;
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
            return authConfig.getAuthenticationManager();
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("api/registrarse", "api/iniciar", "api/public").permitAll()
                            .anyRequest().authenticated()
                    )
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authenticationProvider(authenticationProvider())
                    .addFilterBefore(authFiltroToken, UsernamePasswordAuthenticationFilter.class);

            return http.build();
        }
    } 

