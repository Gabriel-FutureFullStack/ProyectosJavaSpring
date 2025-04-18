package com.pixelpulse.pregunta01ec03.payload;

import java.io.Serializable;

public class AutenticacionLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    public AutenticacionLogin() {
    }
    public AutenticacionLogin(String username, String password) {
        this.username = username;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
