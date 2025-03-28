package com.pixelpulse.pregunta03ec03.model;

public class Usuario {
	private String username;
	private String password;
	private String token;
	public Usuario() {
		super();
	}
	public Usuario(String username, String password, String token) {
		super();
		this.username = username;
		this.password = password;
		this.token = token;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
