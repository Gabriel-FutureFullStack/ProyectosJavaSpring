package com.pixelpulse.entidadfinanciera.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pixelpulse.entidadfinanciera.model.Prestamo;
import com.pixelpulse.entidadfinanciera.service.PrestamoService;

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




@RestController
@RequestMapping("/prestamo")
public class PrestamoRestController {
    private PrestamoService prestamoService;
	public PrestamoRestController(PrestamoService prestamoService) {
		this.prestamoService = prestamoService;
	}
	
	@GetMapping("/listar")
	public ResponseEntity<Collection<Prestamo>> listar() {
		Collection<Prestamo> itemsPrestamos=prestamoService.findAll();		
		return new ResponseEntity<>(itemsPrestamos,HttpStatus.OK); 
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Prestamo> buscar(@PathVariable Integer id) {
		Prestamo prestamo=prestamoService.findById(id);		
		if(prestamo!=null) {
			return new ResponseEntity<>(prestamo,HttpStatus.OK); 
		}		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<Prestamo> agregar(@RequestBody Prestamo prestamo) {
		prestamoService.insert(prestamo);		
		return new ResponseEntity<>(prestamo,HttpStatus.CREATED); 
	}
 
	@PutMapping("/editar/{id}")
	public ResponseEntity<Prestamo> editar(@PathVariable Integer id,
                                        @RequestBody Prestamo newPrestamo) {		
		Prestamo prestamo = prestamoService.findById(id);		
		if(prestamo!=null) {
			prestamo.setFecha(newPrestamo.getFecha());
			prestamo.setImportePrestado(newPrestamo.getImportePrestado());
            prestamo.setNameCliente(newPrestamo.getNameCliente());
            prestamo.setNameFinancista(newPrestamo.getNameFinancista());
            prestamo.setNumeroLetras(newPrestamo.getNumeroLetras());
            prestamo.setInteres(newPrestamo.getInteres());
			prestamoService.update(prestamo);			
			return new ResponseEntity<>(prestamo, HttpStatus.OK);
		}		
		return new ResponseEntity<>(prestamo,HttpStatus.NOT_FOUND);
	}
 
	@DeleteMapping("/borrar/{id}") 
	public ResponseEntity<String> borrar(@PathVariable Integer id)
	{
		Prestamo prestamo = prestamoService.findById(id);
		
		if(prestamo!=null) {
			prestamoService.delete(id);
			return new ResponseEntity<>("Registro eliminado Correctamente", HttpStatus.OK); 
		}		
		return new ResponseEntity<>("Eliminacion fallida",HttpStatus.NOT_FOUND); 
	}
    
}
