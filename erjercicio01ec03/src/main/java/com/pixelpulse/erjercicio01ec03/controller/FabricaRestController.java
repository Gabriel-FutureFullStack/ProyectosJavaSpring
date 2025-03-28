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

import com.pixelpulse.erjercicio01ec03.model.Fabrica;
import com.pixelpulse.erjercicio01ec03.service.FabricaService;

@RestController
@RequestMapping("/api/fabricas")
public class FabricaRestController {
    private FabricaService service;
    public FabricaRestController(FabricaService service) {
        this.service = service;
    }
    @GetMapping("/listar")
    public ResponseEntity<Collection<Fabrica>> listar() {
        Collection<Fabrica> listaFabricas = service.getAll();
        return new ResponseEntity<>(listaFabricas, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}") 
    public ResponseEntity<Fabrica> buscar(@PathVariable Long id) {
		Fabrica fabricaBd=service.getById(id);		
		if(fabricaBd!=null) {
			return new ResponseEntity<>(fabricaBd,HttpStatus.OK);
		}		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	}
    @PostMapping("/agregar")
	public ResponseEntity<String> agregar(@RequestBody Fabrica fabrica) {
		service.insert(fabrica);		
		return new ResponseEntity<>("Fabrica Agregado Correctamente", HttpStatus.CREATED); 
	}
    @PutMapping("/editar/{id}")
	public ResponseEntity<Fabrica> editar(@PathVariable Long id, @RequestBody Fabrica newFabrica) {		
		service.update(newFabrica, id);
        return ResponseEntity.ok(newFabrica);
	}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        boolean deletedFabrica = service.delete(id);
        if (deletedFabrica) {
            return ResponseEntity.ok("Fabrica eliminado Correctamente");
        }
        return ResponseEntity.badRequest().build();
    }
}
