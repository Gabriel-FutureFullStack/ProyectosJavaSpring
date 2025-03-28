package com.pixelpulse.pregunta01ec03.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pixelpulse.pregunta01ec03.model.Cliente;
import com.pixelpulse.pregunta01ec03.repository.ClienteRepository;

import jakarta.transaction.Transactional;


@Service
public class ClienteServiceImpl implements ClienteService {
    //Inicializamos el repositorio
    private ClienteRepository repository;
    public ClienteServiceImpl(ClienteRepository repository){
        this.repository = repository;
    }

    //Implementamos los metodos de la interfaz
    @Override
	@Transactional
    public void insert(Cliente entidad) {
        repository.save(entidad);
    }

    @Override
	@Transactional
    public Cliente update(Cliente entidad, String dni) {
        Optional<Cliente> optional = repository.findById(dni);
        if(!optional.isPresent()) {
            return null;
        }
        Cliente clienteEncontrado = optional.get();
        entidad.setDniCliente(dni);
        entidad.setApellidosCliente(entidad.getApellidosCliente() != null ? entidad.getApellidosCliente() : clienteEncontrado.getApellidosCliente());
        entidad.setNombresCliente(entidad.getNombresCliente() != null ? entidad.getNombresCliente() : clienteEncontrado.getNombresCliente());
        entidad.setDomicilioLegal(entidad.getDomicilioLegal() != null ? entidad.getDomicilioLegal() : clienteEncontrado.getDomicilioLegal());
        entidad.setFechaNac(entidad.getFechaNac() != null ? entidad.getFechaNac() : clienteEncontrado.getFechaNac());
        entidad.setUsername(entidad.getUsername() != null ? entidad.getUsername() : clienteEncontrado.getUsername());
        entidad.setPassword(entidad.getPassword() != null ? entidad.getPassword() : clienteEncontrado.getPassword());
        entidad.setItemsRol(clienteEncontrado.getItemsRol());
        repository.saveAndFlush(entidad);
        return entidad;
    }

    @Override
	@Transactional
    public boolean delete(String dni) {
        Cliente clienteEncontrado = getByDni(dni);
        repository.delete(clienteEncontrado);
		return true;
    }
    @Override
	@Transactional
    public Cliente getByDni(String dni) {
        return repository.findById(dni).orElse(null);
    }
    @Override
	@Transactional
    public Collection<Cliente> getAll() {
        return repository.findAll();
    }
}
