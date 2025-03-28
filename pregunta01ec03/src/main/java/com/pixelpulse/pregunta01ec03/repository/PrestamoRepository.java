package com.pixelpulse.pregunta01ec03.repository;

import org.springframework.stereotype.Repository;
import com.pixelpulse.pregunta01ec03.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository 
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
