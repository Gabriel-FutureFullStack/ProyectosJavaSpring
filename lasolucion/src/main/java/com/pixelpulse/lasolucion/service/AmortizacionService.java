package com.pixelpulse.lasolucion.service;

import java.util.Collection;

import com.pixelpulse.lasolucion.model.Amortizacion;



public interface AmortizacionService {
	public abstract void insert(Amortizacion amortizacion);
	public abstract void update(Amortizacion amortizacion);
	public abstract void delete(int id);
	public abstract Amortizacion findById(int id);
	public abstract Collection<Amortizacion> findAll();
}
