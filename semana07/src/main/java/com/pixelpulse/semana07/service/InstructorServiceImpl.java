package com.pixelpulse.semana07.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.pixelpulse.semana07.model.Instructor;
import com.pixelpulse.semana07.repository.InstructorRepository;

import jakarta.transaction.Transactional;

@Service
public class InstructorServiceImpl implements InstructorService{
	private InstructorRepository repository;
	
	public InstructorServiceImpl(InstructorRepository repository) {
		this.repository = repository;
	}
	
	@Override
	@Transactional
	public Collection<Instructor> getAll(){
		return repository.findAll();
	}
}
