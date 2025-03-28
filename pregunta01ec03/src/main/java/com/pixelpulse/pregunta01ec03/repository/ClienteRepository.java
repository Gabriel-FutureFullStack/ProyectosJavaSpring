package com.pixelpulse.pregunta01ec03.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pixelpulse.pregunta01ec03.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    // Aquí puedes agregar métodos personalizados si es necesario
    @Query("SELECT c FROM Cliente c WHERE c.username = ?1")
    Optional<Cliente> buscarUsuarioPorUsername(String username);

    @Query("SELECT c FROM Cliente c WHERE c.correo = ?1")
    Optional<Cliente> buscarUsuarioPorCorreo(String correo);
}
