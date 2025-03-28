package com.pixelpulse.pregunta01ec03.service;

import java.util.Collection;

import com.pixelpulse.pregunta01ec03.model.Cliente;

public interface ClienteService {
    public abstract void insert(Cliente entidad);
    public abstract Cliente update(Cliente entidad, String dni);
    public abstract boolean delete(String dni);
    public abstract Cliente getByDni(String dni);
    public abstract Collection<Cliente> getAll();
}
