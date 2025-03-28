package com.pixelpulse.pregunta01ec03.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixelpulse.pregunta01ec03.model.Rol;
import com.pixelpulse.pregunta01ec03.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository repository;

    @Override
    public Collection<Rol> getAll() {
        return repository.findAll();
    }

    @Override
    public Rol getById(Integer idRol) {
        return repository.findById(idRol).orElse(null);
    }
}
