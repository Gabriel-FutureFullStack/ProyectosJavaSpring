package com.pixelpulse.pregunta01ec03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pixelpulse.pregunta01ec03.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}
