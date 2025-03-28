package com.pixelpulse.erjercicio01ec03.service;

import java.util.Collection;

import com.pixelpulse.erjercicio01ec03.model.Articulo;

public interface ArticuloService {
    public abstract void insert(Articulo entidad);
    public abstract Articulo update(Articulo entidad, Long id);
    public abstract boolean delete(Long id);
    public abstract Articulo getById(Long id);
    public abstract Collection<Articulo> getAll();
}
