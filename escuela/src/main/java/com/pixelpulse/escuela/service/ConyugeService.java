package com.pixelpulse.escuela.service;

import java.util.Collection;

import com.pixelpulse.escuela.model.Conyuge;

public interface ConyugeService {
    public abstract void insert(Conyuge instructor);
	public abstract void update(Conyuge instructor);
	public abstract void delete(Integer instructorId);
	public abstract Conyuge findById(Integer instructorId);
	public abstract Collection<Conyuge> findAll();
}
