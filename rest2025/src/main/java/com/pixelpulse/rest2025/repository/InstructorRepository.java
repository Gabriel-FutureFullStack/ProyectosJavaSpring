package com.pixelpulse.rest2025.repository;
import java.util.Collection;

//import org.springframework.data.jpa.repository.JpaRepository;

import com.pixelpulse.rest2025.model.Instructor;

//public interface InstructorRepository extends JpaRepository<Instructor, Long>
public interface InstructorRepository{
	public abstract void insert(Instructor instructor);
	public abstract void update(Instructor instructor);
	public abstract void delete(Long id);
	public abstract Instructor findById(Long id);
	public abstract Collection<Instructor> findAll();
}
