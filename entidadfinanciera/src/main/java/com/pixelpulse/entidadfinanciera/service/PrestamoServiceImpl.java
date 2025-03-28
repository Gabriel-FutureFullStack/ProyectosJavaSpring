package com.pixelpulse.entidadfinanciera.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.pixelpulse.entidadfinanciera.model.Prestamo;
import com.pixelpulse.entidadfinanciera.repository.PrestamoRepository;

@Service
public class PrestamoServiceImpl implements PrestamoService {
    private PrestamoRepository prestamoRepository;
    public PrestamoServiceImpl(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }
    @Override
    public void insert(Prestamo prestamo) {
        prestamoRepository.insert(prestamo);
    }

    @Override
    public void update(Prestamo prestamo) {
        prestamoRepository.update(prestamo);
    }

    @Override
    public void delete(Integer id) {
        prestamoRepository.delete(id);
    }

    @Override
    public Prestamo findById(Integer id) {
        return prestamoRepository.findById(id);
    }

    @Override
    public Collection<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }

}
