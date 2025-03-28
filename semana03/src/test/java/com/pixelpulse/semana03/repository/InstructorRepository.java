package com.pixelpulse.semana03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pixelpulse.semana03.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
