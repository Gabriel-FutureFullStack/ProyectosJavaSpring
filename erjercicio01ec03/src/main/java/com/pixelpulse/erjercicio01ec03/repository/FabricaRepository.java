package com.pixelpulse.erjercicio01ec03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pixelpulse.erjercicio01ec03.model.Fabrica;

@Repository
public interface FabricaRepository extends JpaRepository<Fabrica, Long> {

}
