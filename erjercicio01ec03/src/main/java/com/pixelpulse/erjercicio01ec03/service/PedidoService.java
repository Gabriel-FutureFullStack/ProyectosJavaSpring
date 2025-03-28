package com.pixelpulse.erjercicio01ec03.service;

import java.util.Collection;

import com.pixelpulse.erjercicio01ec03.model.Pedido;

public interface PedidoService {
    public abstract void insert(Pedido entidad);
    public abstract Pedido update(Pedido entidad, Long id);
    public abstract boolean delete(Long id);
    public abstract Pedido getById(Long id);
    public abstract Collection<Pedido> getAll();
}
