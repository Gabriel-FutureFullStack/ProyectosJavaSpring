package com.pixelpulse.proyectos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.pixelpulse.proyectos.model.Proyecto;
import com.pixelpulse.proyectos.service.ProyectoService;


@RestController
@RequestMapping("/proyecto")
public class ProyectoController {
	@Autowired
	private ProyectoService pService;
	
	@GetMapping("/listar") 
	public ResponseEntity<?> listar() {
		Collection<Proyecto> itemsP=pService.findAll();		
		return new ResponseEntity<>(itemsP,HttpStatus.OK); 
	}
	
	@GetMapping("/buscar/{id}") 
	public ResponseEntity<?> buscar(@PathVariable Long id) {
		Proyecto proyectoDb=pService.findById(id);		
		if(proyectoDb!=null) {
			return new ResponseEntity<>(proyectoDb,HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Proyecto instructor) {
		pService.insert(instructor);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); 
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar(@PathVariable Long id,
                                        @RequestBody Proyecto newProyecto) {		
		Proyecto proyectoDb=pService.findById(id);		
		if(proyectoDb!=null) {
			newProyecto.setCodP(id);
			proyectoDb.setCodAvObra(newProyecto.getCodAvObra());
			proyectoDb.setCodP(newProyecto.getCodP());
			proyectoDb.setDescAv(newProyecto.getDescAv());
			proyectoDb.setFechAv(newProyecto.getFechAv());
			proyectoDb.setIncidencia(newProyecto.getIncidencia());
			proyectoDb.setIngenieroP(newProyecto.getIngenieroP());
			proyectoDb.setIngenieroResp(newProyecto.getIngenieroResp());
			proyectoDb.setLugarP(newProyecto.getLugarP());
			proyectoDb.setNameP(newProyecto.getNameP());
			
			pService.update(proyectoDb);			
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrar(@PathVariable Long id)
	{
		Proyecto proyectoDb=pService.findById(id);
		
		if(proyectoDb!=null) {
			pService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
