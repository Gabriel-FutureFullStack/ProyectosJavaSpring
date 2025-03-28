package com.pixelpulse.diamante.controller;

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

import com.pixelpulse.diamante.model.Proyectos;
import com.pixelpulse.diamante.service.ProyectosService;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectosRestController {
    private ProyectosService proyectosService;
	public ProyectosRestController(ProyectosService proyectosService) {
		this.proyectosService = proyectosService;
	}
	
	@GetMapping("/listar")
	public ResponseEntity<Collection<Proyectos>> listar() {
		Collection<Proyectos> itemsProyectos=proyectosService.findAll();		
		return new ResponseEntity<>(itemsProyectos,HttpStatus.OK); 
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Proyectos> buscar(@PathVariable Integer id) {
		Proyectos proyecto=proyectosService.findById(id);		
		if(proyecto!=null) {
			return new ResponseEntity<>(proyecto,HttpStatus.OK); 
		}		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<Proyectos> agregar(@RequestBody Proyectos proyecto) {
		proyectosService.insert(proyecto);		
		return new ResponseEntity<>(proyecto,HttpStatus.CREATED); 
	}
 
	@PutMapping("/editar/{id}")
	public ResponseEntity<Proyectos> editar(@PathVariable Integer id,
                                        @RequestBody Proyectos newProyecto) {		
		Proyectos proyecto = proyectosService.findById(id);		
		if(proyecto!=null) {
			proyecto.setNombre(newProyecto.getNombre());
            proyecto.setUbicacion(newProyecto.getUbicacion());
            proyecto.setMunicipalidad(newProyecto.getMunicipalidad());
            proyecto.setFechaAprobacion(newProyecto.getFechaAprobacion());
            proyecto.setTiempoEstimado(newProyecto.getTiempoEstimado());
            proyecto.setFechaTermino(newProyecto.getFechaTermino());
            proyecto.setImporteInversion(newProyecto.getImporteInversion());
            proyecto.setIngResponsable(newProyecto.getIngResponsable());
            proyecto.setIngResponsable(newProyecto.getIngResponsable());
            proyecto.setFinanciera(newProyecto.getFinanciera());
            proyecto.setDescripcion(newProyecto.getDescripcion());
			proyectosService.update(proyecto);			
			return new ResponseEntity<>(proyecto, HttpStatus.OK);
		}		
		return new ResponseEntity<>(proyecto,HttpStatus.NOT_FOUND);
	}
 
	@DeleteMapping("/borrar/{id}") 
	public ResponseEntity<String> borrar(@PathVariable Integer id)
	{
		Proyectos prestamo = proyectosService.findById(id);
		
		if(prestamo!=null) {
			proyectosService.delete(id);
			return new ResponseEntity<>("Registro eliminado Correctamente", HttpStatus.OK); 
		}		
		return new ResponseEntity<>("Eliminacion fallida",HttpStatus.NOT_FOUND); 
	}
}
