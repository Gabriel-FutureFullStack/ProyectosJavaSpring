package com.pixelpulse.diamante.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pixelpulse.diamante.model.Proyectos;

@Repository
public class ProyectosRepositoryImpl implements ProyectosRepository {
    public static Collection<Proyectos> proyectos = new ArrayList();
    @Override
    public void insert(Proyectos proyecto) {
        proyectos.add(proyecto);
    }

    @Override
    public void update(Proyectos proyecto) {
        Proyectos proyectoEncontrado = findById(proyecto.getId());
		proyectos.remove(proyectoEncontrado);
		insert(proyecto);
    }

    @Override
    public void delete(Integer id) {
        Proyectos proyectoEncontrado = findById(id);
		proyectos.remove(proyectoEncontrado);
    }

    @Override
    public Proyectos findById(Integer id) {
        Optional<Proyectos> proyecto = proyectos.stream().filter(p -> p.getId().equals(id)).findFirst();
        return proyecto.orElse(null);  
    }

    @Override
    public Collection<Proyectos> findAll() {
       return proyectos;
    }

}
