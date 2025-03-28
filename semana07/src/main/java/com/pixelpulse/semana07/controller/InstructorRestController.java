package com.pixelpulse.semana07.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pixelpulse.semana07.model.Instructor;

import com.pixelpulse.semana07.service.InstructorService;

@RestController
@RequestMapping("/api")
public class InstructorRestController {
	private InstructorService service;
	public InstructorRestController(InstructorService service) {
		this.service = service;
	}
	
	@GetMapping("/listar_public")
	public ResponseEntity<?> listarPUBLIC() 	{
		Collection<Instructor> itemsInstructor=service.getAll();
		
		if(itemsInstructor.isEmpty()) {
			return new ResponseEntity<>(itemsInstructor,HttpStatus.NO_CONTENT);
		}		
		return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
	}
	
	@GetMapping("/listar_admin")
	public ResponseEntity<?> listarADMIN() {
		Collection<Instructor> itemsInstructor=service.getAll();
		
		if(itemsInstructor.isEmpty()) {
			return new ResponseEntity<>(itemsInstructor,HttpStatus.NO_CONTENT);
		}		
		return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
	}
	
	@GetMapping("/listar_user")
	public ResponseEntity<?> listarUSER() {
		Collection<Instructor> itemsInstructor=service.getAll();
		
		if(itemsInstructor.isEmpty()) {
			return new ResponseEntity<>(itemsInstructor,HttpStatus.NO_CONTENT);
		}		
		return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
	}
}
