package com.pixelpulse.pregunta02ec03.dto;


// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
public class User {
    private String username;
    private String pass;
    private String token;

    public User() {
        super();
    }

    public User(String username, String pass, String token) {
        this.username = username;
        this.pass = pass;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
