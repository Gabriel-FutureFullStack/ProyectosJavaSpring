package com.pixelpulse.entidadfinanciera.repository;

import java.util.Collection;

import com.pixelpulse.entidadfinanciera.model.Prestamo;

public interface PrestamoRepository {
    public abstract void insert(Prestamo prestamo);
	public abstract void update(Prestamo prestamo);
	public abstract void delete(Integer id);
	public abstract Prestamo findById(Integer id);
	public abstract Collection<Prestamo> findAll();
}
