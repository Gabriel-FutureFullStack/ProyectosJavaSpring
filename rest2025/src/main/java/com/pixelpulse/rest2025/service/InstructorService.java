package com.pixelpulse.rest2025.service;

import java.util.Collection;
import com.pixelpulse.rest2025.model.Instructor;


public interface InstructorService {
	public abstract void insert(Instructor instructor);
	public abstract void update(Instructor instructor);
	public abstract void delete(Long id);
	public abstract Instructor findById(Long id);
	public abstract Collection<Instructor> findAll();
}
