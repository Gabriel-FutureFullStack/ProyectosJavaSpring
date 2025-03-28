package com.pixelpulse.rest2025.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixelpulse.rest2025.model.Instructor;
import com.pixelpulse.rest2025.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {
	@Autowired
	private InstructorRepository repository;
	
	@Override
	public void insert(Instructor instructor) {
		repository.insert(instructor);
	}
	@Override
	public void update(Instructor instructor) {
		repository.update(instructor);
	}
	@Override
	public void delete(Long id) {
		repository.delete(id);
	}
	@Override	
	public Instructor findById(Long id) {
		return repository.findById(id);
	}
	
	@Override	
	public Collection<Instructor> findAll() {
		return repository.findAll();
	}

}
