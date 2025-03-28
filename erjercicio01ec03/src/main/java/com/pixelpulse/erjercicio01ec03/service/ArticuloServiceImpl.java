package com.pixelpulse.erjercicio01ec03.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pixelpulse.erjercicio01ec03.model.Articulo;
import com.pixelpulse.erjercicio01ec03.repository.ArticuloRepository;

import jakarta.transaction.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {
    
    private ArticuloRepository repository;
    public ArticuloServiceImpl(ArticuloRepository repository) {
        this.repository = repository;
    }

    @Override
	@Transactional
    public void insert(Articulo entidad) {
        repository.save(entidad);
    }
    @Override
	@Transactional
    public Articulo update(Articulo entidad, Long id) {
        Optional<Articulo> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return null;
        }
        Articulo articuloEncontrado = optional.get();
        entidad.setNumArticulo(id);
        entidad.setDescripcion(entidad.getDescripcion() != null ? entidad.getDescripcion() : articuloEncontrado.getDescripcion());
        repository.saveAndFlush(entidad);
        return entidad;
    }
    @Override
	@Transactional
    public boolean delete(Long id) {
        Articulo articuloEncontrado = getById(id);
        repository.delete(articuloEncontrado);
		return true;
    }
    @Override
	@Transactional
    public Articulo getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
	@Transactional
    public Collection<Articulo> getAll() {
        return repository.findAll();
    }

}
