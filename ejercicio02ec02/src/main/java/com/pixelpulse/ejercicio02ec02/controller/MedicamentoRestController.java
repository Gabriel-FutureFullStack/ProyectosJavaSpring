package com.pixelpulse.ejercicio02ec02.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pixelpulse.ejercicio02ec02.model.Medicamento;
import com.pixelpulse.ejercicio02ec02.service.MedicamentoService;

@RestController
@RequestMapping("/api")
public class MedicamentoRestController {
    private MedicamentoService service;
    public MedicamentoRestController(MedicamentoService service){
        this.service = service;
    }
    @GetMapping("/listar_public")
	public ResponseEntity<?> listarPUBLIC() 	{
		Collection<Medicamento> itemsInstructor=service.listAllMedicamentos();
		
		if(itemsInstructor.isEmpty()) {
			return new ResponseEntity<>(itemsInstructor,HttpStatus.NO_CONTENT);
		}		
		return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
	}
	
	@GetMapping("/listar_admin")
	public ResponseEntity<?> listarADMIN() {
		Collection<Medicamento> itemsInstructor=service.listAllMedicamentos();
		
		if(itemsInstructor.isEmpty()) {
			return new ResponseEntity<>(itemsInstructor,HttpStatus.NO_CONTENT);
		}		
		return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
	}
	
	@GetMapping("/listar_user")
	public ResponseEntity<?> listarUSER() {
		Collection<Medicamento> itemsInstructor=service.listAllMedicamentos();
		
		if(itemsInstructor.isEmpty()) {
			return new ResponseEntity<>(itemsInstructor,HttpStatus.NO_CONTENT);
		}		
		return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
	}
}
