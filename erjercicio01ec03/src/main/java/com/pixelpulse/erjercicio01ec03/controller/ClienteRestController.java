package com.pixelpulse.erjercicio01ec03.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pixelpulse.erjercicio01ec03.model.Cliente;
import com.pixelpulse.erjercicio01ec03.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {
    private ClienteService service;
    public ClienteRestController(ClienteService service) {
        this.service = service;
    }
    @GetMapping("/listar")
    public ResponseEntity<Collection<Cliente>> listar() {
        Collection<Cliente> listaClientes = service.getAll();
        return new ResponseEntity<>(listaClientes, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}") 
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
		Cliente clienteoBd=service.getById(id);		
		if(clienteoBd!=null) {
			return new ResponseEntity<>(clienteoBd,HttpStatus.OK);
		}		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	}
    @PostMapping("/agregar")
	public ResponseEntity<String> agregar(@RequestBody Cliente cliente) {
		service.insert(cliente);		
		return new ResponseEntity<>("Cliente Agregado Correctamente", HttpStatus.CREATED); 
	}
    @PutMapping("/editar/{id}")
	public ResponseEntity<Cliente> editar(@PathVariable Long id, @RequestBody Cliente newCliente) {		
		service.update(newCliente, id);
        return ResponseEntity.ok(newCliente);
	}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        boolean deletedCliente = service.delete(id);
        if (deletedCliente) {
            return ResponseEntity.ok("Cliente eliminado Correctamente");
        }
        return ResponseEntity.badRequest().build();
    }
}
