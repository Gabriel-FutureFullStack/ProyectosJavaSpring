package com.pixelpulse.rest2025.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.pixelpulse.rest2025.model.Instructor;

@Repository
public class InstructorRepositoryImpl implements InstructorRepository {
	public static Collection<Instructor> itemsInstructor=new ArrayList<>();
	
	@Override
	public void insert(Instructor instructor) {
		itemsInstructor.add(instructor);
	}
	@Override
	public void update(Instructor instructor) {
		Instructor instructorBuscado = findById(instructor.getId());
		itemsInstructor.remove(instructorBuscado);
		insert(instructor);
	}
	@Override
	public void delete(Long id) {
		Instructor instructorBuscado = findById(id);
		itemsInstructor.remove(instructorBuscado);
	}
	@Override	
	public Instructor findById(Long id) {
		Optional<Instructor> instructorBuscado = itemsInstructor.stream().filter(p -> p.getId() == id).findFirst();
		return instructorBuscado.orElse(null);
	}
	
	@Override	
	public Collection<Instructor> findAll() {
		return itemsInstructor;
	}
}
