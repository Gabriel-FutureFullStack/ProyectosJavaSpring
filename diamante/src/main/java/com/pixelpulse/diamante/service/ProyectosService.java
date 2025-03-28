package com.pixelpulse.diamante.service;

import java.util.Collection;

import com.pixelpulse.diamante.model.Proyectos;

public interface ProyectosService {
    public abstract void insert(Proyectos proyecto);
	public abstract void update(Proyectos proyecto);
	public abstract void delete(Integer id);
	public abstract Proyectos findById(Integer id);
	public abstract Collection<Proyectos> findAll();
}
