package com.pixelpulse.escuela.service;

import java.util.Collection;

import com.pixelpulse.escuela.model.Taller;
 
 
public interface TallerService {
 
	public abstract void insert(Taller taller);
	public abstract void update(Taller taller);
	public abstract void delete(Integer tallerId);
	public abstract Taller findById(Integer tallerId);
	public abstract Collection<Taller> findAll();
}
