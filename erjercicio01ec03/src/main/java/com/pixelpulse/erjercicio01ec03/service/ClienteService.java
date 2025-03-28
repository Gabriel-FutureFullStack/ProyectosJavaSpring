package com.pixelpulse.erjercicio01ec03.service;

import java.util.Collection;

import com.pixelpulse.erjercicio01ec03.model.Cliente;

public interface ClienteService {
    public abstract void insert(Cliente entidad);
    public abstract Cliente update(Cliente entidad, Long id);
    public abstract boolean delete(Long id);
    public abstract Cliente getById(Long id);
    public abstract Collection<Cliente> getAll();
}
