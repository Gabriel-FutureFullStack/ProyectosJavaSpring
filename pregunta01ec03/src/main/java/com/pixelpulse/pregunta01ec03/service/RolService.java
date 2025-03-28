package com.pixelpulse.pregunta01ec03.service;

import java.util.Collection;

import com.pixelpulse.pregunta01ec03.model.Rol;

public interface RolService {
    
    public abstract Collection<Rol> getAll();
    public abstract Rol getById(Integer id); 
}
