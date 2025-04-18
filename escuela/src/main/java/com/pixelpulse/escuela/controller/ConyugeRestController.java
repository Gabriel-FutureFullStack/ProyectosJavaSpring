package com.pixelpulse.escuela.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.pixelpulse.escuela.model.Conyuge;
import com.pixelpulse.escuela.service.ConyugeService;

 
@RestController
@RequestMapping("/conyuge")
public class ConyugeRestController {
	@Autowired
	private ConyugeService conyugeService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		Collection<Conyuge> itemsConyuge=conyugeService.findAll();
		return new ResponseEntity<>(itemsConyuge,HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Conyuge conyuge) {
		conyugeService.insert(conyuge);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
