package com.pixelpulse.erjercicio01ec03.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pixelpulse.erjercicio01ec03.model.Pedido;
import com.pixelpulse.erjercicio01ec03.repository.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository repository;
    private ClienteService serviceClient;
    public PedidoServiceImpl(PedidoRepository repository, ClienteService serviceClient) {
        this.repository = repository;
        this.serviceClient = serviceClient;
    }

    @Override
    @Transactional
    public void insert(Pedido entidad) {
        repository.save(entidad);
    }
    @Override
    @Transactional
    public Pedido update(Pedido entidad, Long id) {
        Optional<Pedido> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return null;
        }
        Pedido pedidoEncontrado = optional.get();
        entidad.setNumPedido(id);
        entidad.setFechaPedido(entidad.getFechaPedido() != null ? entidad.getFechaPedido() : pedidoEncontrado.getFechaPedido());
        entidad.setDireccionEnvio(entidad.getDireccionEnvio() != null ? entidad.getDireccionEnvio() : pedidoEncontrado.getDireccionEnvio());
        entidad.setFechaPedido(entidad.getFechaPedido() != null ? entidad.getFechaPedido() : pedidoEncontrado.getFechaPedido());
        entidad.setCliente(entidad.getCliente()!= null ? entidad.getCliente() : pedidoEncontrado.getCliente());
        // entidad.setCliente(entidad.getCliente()!= null ? serviceClient.getById(entidad.getCliente().getNumCliente()) : pedidoEncontrado.getCliente());
        repository.saveAndFlush(entidad);
        return entidad;
    }
    @Override
	@Transactional
    public boolean delete(Long id) {
        Pedido pedidoEncontrado = getById(id);
        repository.delete(pedidoEncontrado);
		return true;
    }
    @Override
	@Transactional
    public Pedido getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
	@Transactional
    public Collection<Pedido> getAll() {
        return repository.findAll();
    }
}
