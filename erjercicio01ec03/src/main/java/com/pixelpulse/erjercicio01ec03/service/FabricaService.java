package com.pixelpulse.erjercicio01ec03.service;

import java.util.Collection;

import com.pixelpulse.erjercicio01ec03.model.Fabrica;

public interface FabricaService {
    public abstract void insert(Fabrica entidad);
    public abstract Fabrica update(Fabrica entidad, Long id);
    public abstract boolean delete(Long id);
    public abstract Fabrica getById(Long id);
    public abstract Collection<Fabrica> getAll();
}
