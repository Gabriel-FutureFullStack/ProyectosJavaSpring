package com.pixelpulse.pregunta01ec03.payload;

import java.io.Serializable;

public class AutenticacionRegistro implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String email;
    private String password;
    public AutenticacionRegistro() {
    }
    public AutenticacionRegistro(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
