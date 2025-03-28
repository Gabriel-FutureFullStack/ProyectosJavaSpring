package com.pixelpulse.erjercicio01ec03.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pixelpulse.erjercicio01ec03.model.Cliente;
import com.pixelpulse.erjercicio01ec03.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository repository;
    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
	@Transactional
    public void insert(Cliente entidad) {
        repository.save(entidad);
    }
    @Override
	@Transactional
    public Cliente update(Cliente entidad, Long id) {
        Optional<Cliente> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return null;
        }
        Cliente clienteEncontrado = optional.get();
        entidad.setNumCliente(id);
//        genera recursividad
//        entidad.setItemsPedido(clienteEncontrado.getItemsPedido());
        entidad.setNombreCliente(entidad.getNombreCliente() != null ? entidad.getNombreCliente() : clienteEncontrado.getNombreCliente());
        entidad.setDireccion1(entidad.getDireccion1() != null ? entidad.getDireccion1() : clienteEncontrado.getDireccion1());
        entidad.setDireccion2(entidad.getDireccion2() != null ? entidad.getDireccion2() : clienteEncontrado.getDireccion2());
        entidad.setDireccion3(entidad.getDireccion3() != null ? entidad.getDireccion3() : clienteEncontrado.getDireccion3());
        entidad.setSaldo(entidad.getSaldo() != null ? entidad.getSaldo() : clienteEncontrado.getSaldo());
        entidad.setLimiteCredito(entidad.getLimiteCredito() != null ? entidad.getLimiteCredito() : clienteEncontrado.getLimiteCredito());
        entidad.setDescuento(entidad.getDescuento() != null ? entidad.getDescuento() : clienteEncontrado.getDescuento());
        repository.saveAndFlush(entidad);
        return entidad;
    }
    @Override
	@Transactional
    public boolean delete(Long id) {
        Cliente clienteEncontrado = getById(id);
        repository.delete(clienteEncontrado);
		return true;
    }
    @Override
	@Transactional
    public Cliente getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
	@Transactional
    public Collection<Cliente> getAll() {
        return repository.findAll();
    }
}
