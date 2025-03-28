package com.pixelpulse.pregunta01ec03.security.utils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    @Value("${token.palabra.secreta}")
    private String secret;
    
    public Key obtenerClaveSecreta() {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public Claims extraerContenidoClaims(String token){
        return Jwts.parserBuilder().setSigningKey(obtenerClaveSecreta()).build().parseClaimsJws(token).getBody();
    } 

    
    public String extraerUsername(String token){
        return extraerContenidoClaims(token).getSubject();
    }

    public Date extraerTiempoVencimiento(String token){
        return extraerContenidoClaims(token).getExpiration();
    }

    public boolean isTokenExpiration(String token){
        return extraerTiempoVencimiento(token).before(new Date());
    }

    public String prepararEstructuraToken(Map<String, Object> payload, String subject){
        return Jwts.builder()
                .setClaims(payload)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 *60 *60* 10))
                .signWith(obtenerClaveSecreta(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String createToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return prepararEstructuraToken(claims, userDetails.getUsername());
    }


    public boolean validarToken(String token, UserDetails userDetails){
        final String username = extraerUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpiration(token));
    }
}
