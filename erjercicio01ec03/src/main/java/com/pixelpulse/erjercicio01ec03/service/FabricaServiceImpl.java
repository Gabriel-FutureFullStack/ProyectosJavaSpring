package com.pixelpulse.erjercicio01ec03.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pixelpulse.erjercicio01ec03.model.Fabrica;
import com.pixelpulse.erjercicio01ec03.repository.FabricaRepository;

import jakarta.transaction.Transactional;

@Service
public class FabricaServiceImpl implements FabricaService {

    private FabricaRepository repository;
    public FabricaServiceImpl(FabricaRepository repository) {
        this.repository = repository;
    }

    @Override
	@Transactional
    public void insert(Fabrica entidad) {
        repository.save(entidad);
    }
    @Override
	@Transactional
    public Fabrica update(Fabrica entidad, Long id) {
        Optional<Fabrica> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return null;
        }
        Fabrica fabricaEncontrado = optional.get();
        entidad.setNumFabrica(id);
        entidad.setNombreFabrica(entidad.getNombreFabrica() != null ? entidad.getNombreFabrica() : fabricaEncontrado.getNombreFabrica());
        entidad.setDireccion(entidad.getDireccion() != null ? entidad.getDireccion() : fabricaEncontrado.getDireccion());
        entidad.setTelefonoContacto(entidad.getTelefonoContacto() != null ? entidad.getTelefonoContacto() : fabricaEncontrado.getTelefonoContacto());
        repository.saveAndFlush(entidad);
        return entidad;
    }
    @Override
	@Transactional
    public boolean delete(Long id) {
        Fabrica fabricaEncontrado = getById(id);
        repository.delete(fabricaEncontrado);
		return true;
    }
    @Override
	@Transactional
    public Fabrica getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
	@Transactional
    public Collection<Fabrica> getAll() {
        return repository.findAll();
    }
} 
