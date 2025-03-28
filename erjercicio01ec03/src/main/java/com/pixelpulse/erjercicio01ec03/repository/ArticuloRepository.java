package com.pixelpulse.erjercicio01ec03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pixelpulse.erjercicio01ec03.model.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

}
