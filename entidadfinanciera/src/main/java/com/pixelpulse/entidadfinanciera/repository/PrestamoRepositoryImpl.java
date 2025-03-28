package com.pixelpulse.entidadfinanciera.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pixelpulse.entidadfinanciera.model.Prestamo;

@Repository
public class PrestamoRepositoryImpl implements PrestamoRepository {
    public static Collection<Prestamo> prestamos = new ArrayList();
    @Override
    public void insert(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    @Override
    public void update(Prestamo prestamo) {
        Prestamo prestamoEncontrado = findById(prestamo.getId());
		prestamos.remove(prestamoEncontrado);
		insert(prestamo);
    }

    @Override
    public void delete(Integer id) {
        Prestamo prestamoEncontrado = findById(id);
		prestamos.remove(prestamoEncontrado);
    }

    @Override
    public Prestamo findById(Integer id) {
        Optional<Prestamo> prestamo = prestamos.stream().filter(p -> p.getId().equals(id)).findFirst();
        return prestamo.orElse(null);  
    }

    @Override
    public Collection<Prestamo> findAll() {
       return prestamos;
    }

}
