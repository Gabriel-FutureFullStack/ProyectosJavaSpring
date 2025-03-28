package com.pixelpulse.pregunta01ec03.security.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pixelpulse.pregunta01ec03.model.Cliente;
import com.pixelpulse.pregunta01ec03.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class MiUserDetailsService implements UserDetailsService {
    private final ClienteRepository repository;

    public MiUserDetailsService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Cliente> usuario = repository.buscarUsuarioPorUsername(username);
        Cliente clienteEncontrado = usuario.orElseThrow(() -> 
            new UsernameNotFoundException("No se encontró el usuario " + username + " en la BD")
        );

        return new MiUserDetails(clienteEncontrado);
    }
}
