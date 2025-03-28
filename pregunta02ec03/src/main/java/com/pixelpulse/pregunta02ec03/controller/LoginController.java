package com.pixelpulse.pregunta02ec03.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pixelpulse.pregunta02ec03.dto.User;
import com.pixelpulse.pregunta02ec03.security.JWTAuthenticationConfig;

@RestController
public class LoginController {
    
    private final JWTAuthenticationConfig jwtAuthConfig;
    public LoginController(JWTAuthenticationConfig jwtAuthConfig){
        this.jwtAuthConfig = jwtAuthConfig;
    }
    @PostMapping("/login")
    public User login(@RequestParam("usuario") String username, @RequestParam("password") String encryptedPass) {
        String token = jwtAuthConfig.getJWTToken(username);
        return new User(username, encryptedPass, token);
    }
}
