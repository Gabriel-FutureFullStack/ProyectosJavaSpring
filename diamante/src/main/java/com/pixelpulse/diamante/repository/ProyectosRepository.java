package com.pixelpulse.diamante.repository;

import java.util.Collection;

import com.pixelpulse.diamante.model.Proyectos;

public interface ProyectosRepository {
    public abstract void insert(Proyectos proyecto);
	public abstract void update(Proyectos proyecto);
	public abstract void delete(Integer id);
	public abstract Proyectos findById(Integer id);
	public abstract Collection<Proyectos> findAll();
}
