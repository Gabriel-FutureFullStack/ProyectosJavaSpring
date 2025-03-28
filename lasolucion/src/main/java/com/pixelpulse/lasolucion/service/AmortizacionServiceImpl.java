package com.pixelpulse.lasolucion.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixelpulse.lasolucion.model.Amortizacion;
import com.pixelpulse.lasolucion.repository.AmortizacionRepository;


@Service
public class AmortizacionServiceImpl implements AmortizacionService {
	@Autowired
	private AmortizacionRepository repository;
	
	@Override
	public void insert(Amortizacion amortizacion) {
		repository.insert(amortizacion);
	}
	@Override
	public void update(Amortizacion instructor) {
		repository.update(instructor);
	}
	@Override
	public void delete(int id) {
		repository.delete(id);
	}
	@Override	
	public Amortizacion findById(int id) {
		return repository.findById(id);
	}
	
	@Override	
	public Collection<Amortizacion> findAll() {
		return repository.findAll();
	}
}	