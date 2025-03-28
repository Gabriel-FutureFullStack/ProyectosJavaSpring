package com.pixelpulse.erjercicio01ec03.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pixelpulse.erjercicio01ec03.model.Articulo;
import com.pixelpulse.erjercicio01ec03.service.ArticuloService;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/articulos")
public class ArticuloRestController {
    private ArticuloService service;
    public ArticuloRestController(ArticuloService service) {
        this.service = service;
    }
    @GetMapping("/listar")
    public ResponseEntity<Collection<Articulo>> listar() {
        Collection<Articulo> listaArticulos = service.getAll();
        return new ResponseEntity<>(listaArticulos, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}") 
    public ResponseEntity<Articulo> buscar(@PathVariable Long id) {
		Articulo articuloBd=service.getById(id);		
		if(articuloBd!=null) {
			return new ResponseEntity<>(articuloBd,HttpStatus.OK);
		}		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	}
    @PostMapping("/agregar")
	public ResponseEntity<String> agregar(@RequestBody Articulo articulo) {
		service.insert(articulo);		
		return new ResponseEntity<>("Articulo Agregado Correctamente", HttpStatus.CREATED); 
	}
    @PutMapping("/editar/{id}")
	public ResponseEntity<Articulo> editar(@PathVariable Long id, @RequestBody Articulo newArticulo) {		
		service.update(newArticulo, id);
        return ResponseEntity.ok(newArticulo);
	}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        boolean deletedArticulo = service.delete(id);
        if (deletedArticulo) {
            return ResponseEntity.ok("Articulo eliminado Correctamente");
        }
        return ResponseEntity.badRequest().build();
    }
}
