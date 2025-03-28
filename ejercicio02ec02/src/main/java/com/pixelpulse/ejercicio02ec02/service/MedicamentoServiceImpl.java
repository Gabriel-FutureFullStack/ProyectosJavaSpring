package com.pixelpulse.ejercicio02ec02.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.pixelpulse.ejercicio02ec02.model.Medicamento;
import com.pixelpulse.ejercicio02ec02.repository.MedicamentoRepository;

import jakarta.transaction.Transactional;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {
    private MedicamentoRepository repository;

    public MedicamentoServiceImpl(MedicamentoRepository repository) {
        this.repository = repository;
    }
    @Override
    @Transactional
    public Collection<Medicamento> listAllMedicamentos() {
        return repository.findAll();
    }

}
