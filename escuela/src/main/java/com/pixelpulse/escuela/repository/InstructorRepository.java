package com.pixelpulse.escuela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixelpulse.escuela.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
