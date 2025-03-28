package com.pixelpulse.pregunta01ec03.service;

import java.util.Collection;
import com.pixelpulse.pregunta01ec03.model.Prestamo;

public interface PrestamoService {
    public abstract void insert(Prestamo entidad);
    public abstract Prestamo update(Prestamo entidad, Long numPrestamo);
    public abstract boolean delete(Long numPrestamo);
    public abstract Prestamo getById(Long numPrestamo);
    public abstract Collection<Prestamo> getAll();
}
