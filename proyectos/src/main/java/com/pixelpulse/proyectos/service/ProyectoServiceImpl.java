package com.pixelpulse.proyectos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pixelpulse.proyectos.model.Proyecto;
import com.pixelpulse.proyectos.repository.ProyectoRepository;


@Service
public class ProyectoServiceImpl implements ProyectoService {
	@Autowired
	private ProyectoRepository repository;
 
	@Override
	@Transactional
	public void insert(Proyecto proyecto) {
		repository.save(proyecto);		
	}
 
	@Override
	@Transactional
	public void update(Proyecto proyecto) {
		repository.save(proyecto);		
	}
 
	@Override
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);		
	}
 
	@Override
	@Transactional(readOnly=true)
	public Proyecto findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	@Override
	@Transactional(readOnly =true)
	public Collection<Proyecto> findAll() {
		return (Collection<Proyecto>)repository.findAll();
	}
}	
