package com.pixelpulse.diamante.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.pixelpulse.diamante.model.Proyectos;
import com.pixelpulse.diamante.repository.ProyectosRepository;

@Service
public class ProyectosServiceImpl implements ProyectosService {
    ProyectosRepository proyectosRepository;
    public ProyectosServiceImpl(ProyectosRepository proyectosRepository) {
        this.proyectosRepository = proyectosRepository;
    }
    @Override
    public void insert(Proyectos proyecto) {
        proyectosRepository.insert(proyecto);
    }

    @Override
    public void update(Proyectos proyecto) {
        proyectosRepository.update(proyecto);
    }

    @Override
    public void delete(Integer id) {
        proyectosRepository.delete(id);
    }

    @Override
    public Proyectos findById(Integer id) {
        return proyectosRepository.findById(id);
    }

    @Override
    public Collection<Proyectos> findAll() {
        return proyectosRepository.findAll();
    }
}
