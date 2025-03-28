package com.pixelpulse.proyectos.service;

import java.util.Collection;
import com.pixelpulse.proyectos.model.Proyecto;


public interface ProyectoService {
		public abstract void insert(Proyecto instructor);
		public abstract void update(Proyecto instructor);
		public abstract void delete(Long id);
		public abstract Proyecto findById(Long id);
		public abstract Collection<Proyecto> findAll();

}
