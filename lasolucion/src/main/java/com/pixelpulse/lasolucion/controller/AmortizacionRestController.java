package com.pixelpulse.lasolucion.controller;

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

import com.pixelpulse.lasolucion.model.Amortizacion;
import com.pixelpulse.lasolucion.service.AmortizacionService;


@RestController
@RequestMapping("/api/v1")
public class AmortizacionRestController {
	private AmortizacionService aService;
	public AmortizacionRestController(AmortizacionService aService) {
		this.aService = aService;
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		Collection<Amortizacion> itemsA=aService.findAll();		
		return new ResponseEntity<>(itemsA,HttpStatus.OK); 
	}
	
	@GetMapping("/buscar/{numAmortizacion}")
	public ResponseEntity<?> buscar(@PathVariable int numAmortizacion) {
		Amortizacion amortizacion=aService.findById(numAmortizacion);		
		if(amortizacion!=null) {
			return new ResponseEntity<>(amortizacion,HttpStatus.OK); 
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Amortizacion amortizacion) {
		aService.insert(amortizacion);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); 
	}
 
	@PutMapping("/editar/{numAmortizacion}")
	public ResponseEntity<?> editar(@PathVariable int numAmortizacion,
                                        @RequestBody Amortizacion newA) {		
		Amortizacion amortizacion=aService.findById(numAmortizacion);		
		if(amortizacion!=null) {
			amortizacion.setNumPrestamo(newA.getNumPrestamo());
			amortizacion.setDni(newA.getDni());
			amortizacion.setFechPrestamo(newA.getFechPrestamo());
			amortizacion.setImpCapital(newA.getImpCapital());
			amortizacion.setImpInteres(newA.getImpInteres());	
			amortizacion.setImpTAmortizado(newA.getImpTAmortizado());
			aService.update(amortizacion);			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
 
	@DeleteMapping("/borrar/{numAmortizacion}") 
	public ResponseEntity<?> borrar(@PathVariable int numAmortizacion)
	{
		Amortizacion amortizacion=aService.findById(numAmortizacion);
		
		if(amortizacion!=null) {
			aService.delete(numAmortizacion);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
}
