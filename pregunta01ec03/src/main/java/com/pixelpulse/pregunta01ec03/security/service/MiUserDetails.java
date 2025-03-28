package com.pixelpulse.pregunta01ec03.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pixelpulse.pregunta01ec03.model.Cliente;
import com.pixelpulse.pregunta01ec03.model.Rol;

public class MiUserDetails implements UserDetails {

    private String username;
    private String password;
    private boolean enabled;
    private List<SimpleGrantedAuthority> authorities;

    //Metodos
    public MiUserDetails(Cliente usuario) {
        this.authorities = new ArrayList<SimpleGrantedAuthority>();
        this.username = usuario.getUsername();
        this.password = usuario.getPassword();
        this.enabled = usuario.isEstado();
        for(Rol rol : usuario.getItemsRol()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+rol.getNombreRol()));
        }
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
