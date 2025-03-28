package com.pixelpulse.semana07.service;

import java.util.Collection;


import com.pixelpulse.semana07.model.Instructor;

public interface InstructorService {
//	public abstract void insert(Instructor instructor);
//	public abstract void delete(Integer id);
//	public abstract void update(Instructor instructor);
	public abstract Collection<Instructor> getAll();
//	public abstract Instructor getById(Integer id);
}
