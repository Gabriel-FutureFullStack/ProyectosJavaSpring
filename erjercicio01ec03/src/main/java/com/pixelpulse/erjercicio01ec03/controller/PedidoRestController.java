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

import com.pixelpulse.erjercicio01ec03.model.Pedido;
import com.pixelpulse.erjercicio01ec03.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRestController {
    private PedidoService service;
    public PedidoRestController(PedidoService service) {
        this.service = service;
    }
    @GetMapping("/listar")
    public ResponseEntity<Collection<Pedido>> listar() {
        Collection<Pedido> listaPedidos = service.getAll();
        return new ResponseEntity<>(listaPedidos, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}") 
    public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
		Pedido pedidoBd=service.getById(id);		
		if(pedidoBd!=null) {
			return new ResponseEntity<>(pedidoBd,HttpStatus.OK);
		}		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	}
    @PostMapping("/agregar")
	public ResponseEntity<String> agregar(@RequestBody Pedido pedido) {
		service.insert(pedido);		
		return new ResponseEntity<>("Pedido Agregado Correctamente", HttpStatus.CREATED); 
	}
    @PutMapping("/editar/{id}")
	public ResponseEntity<Pedido> editar(@PathVariable Long id, @RequestBody Pedido newPedido) {		
		service.update(newPedido, id);
        return ResponseEntity.ok(newPedido);
	}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        boolean deletedPedido = service.delete(id);
        if (deletedPedido) {
            return ResponseEntity.ok("Pedido eliminado Correctamente");
        }
        return ResponseEntity.badRequest().build();
    }
}
