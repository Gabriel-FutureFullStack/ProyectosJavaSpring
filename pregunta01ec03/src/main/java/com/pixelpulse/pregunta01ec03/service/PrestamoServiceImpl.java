package com.pixelpulse.pregunta01ec03.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pixelpulse.pregunta01ec03.model.Prestamo;
import com.pixelpulse.pregunta01ec03.repository.PrestamoRepository;

import jakarta.transaction.Transactional;

@Service
public class PrestamoServiceImpl implements PrestamoService {
    private PrestamoRepository repository;
    public PrestamoServiceImpl(PrestamoRepository repository) {
        this.repository = repository;
    }
    @Override
	@Transactional
    public void insert(Prestamo entidad) {
        repository.save(entidad);
    }

    @Override
	@Transactional
    public Prestamo update(Prestamo entidad, Long numPrestamo) {
        Optional<Prestamo> optional = repository.findById(numPrestamo);
        if(!optional.isPresent()) {
            return null;
        }
        Prestamo prestamoEncontrado = optional.get();
        entidad.setNumPrestamo(numPrestamo);
        entidad.setFechaPrestamo(entidad.getFechaPrestamo() != null ? entidad.getFechaPrestamo() : prestamoEncontrado.getFechaPrestamo());
        entidad.setImportePrestado(entidad.getImportePrestado() != null ? entidad.getImportePrestado() : prestamoEncontrado.getImportePrestado());
        entidad.setNumCuotas(entidad.getNumCuotas() != null ? entidad.getNumCuotas() : prestamoEncontrado.getNumCuotas());
        entidad.setInteres(entidad.getInteres() != null ? entidad.getInteres() : prestamoEncontrado.getInteres());
        entidad.setCliente(entidad.getCliente() != null ? entidad.getCliente() : prestamoEncontrado.getCliente());
        repository.saveAndFlush(entidad);
        return entidad;
    }

    @Override
	@Transactional
    public boolean delete(Long numPrestamo) {
        Prestamo prestamoEncontrado = getById(numPrestamo);
        repository.delete(prestamoEncontrado);
		return true;
    }
    @Override
	@Transactional
    public Prestamo getById(Long numPrestamo) {
        return repository.findById(numPrestamo).orElse(null);
    }
    @Override
	@Transactional
    public Collection<Prestamo> getAll() {
        return repository.findAll();
    }
}
