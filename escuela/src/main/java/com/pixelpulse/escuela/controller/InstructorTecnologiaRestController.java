package com.pixelpulse.escuela.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.pixelpulse.escuela.model.Instructor;
import com.pixelpulse.escuela.model.InstructorTecnologia;
import com.pixelpulse.escuela.model.Tecnologia;
import com.pixelpulse.escuela.service.InstructorService;
import com.pixelpulse.escuela.service.TecnologiaService;

 
@RestController
@RequestMapping("/instructor_tecnologia")
public class InstructorTecnologiaRestController {
 
	@Autowired
	private InstructorService instructorService;
	
	@Autowired
	private TecnologiaService tecnologiaService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(@RequestBody Instructor instructor)
	{
	    Instructor instructorDb=instructorService.findById(instructor.getInstructorId());
		
	    if(instructorDb!=null)
	    {
		Collection<Tecnologia> itemsTecnologia=instructorDb.getItemsTecnologia();
		return new ResponseEntity<>(itemsTecnologia,HttpStatus.OK);
	    }
		
	    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody InstructorTecnologia instructor_tecnologia)
	{
	    Instructor instructorDb=instructorService.findById(
                                                instructor_tecnologia.getInstructor().getInstructorId());
		
	    if(instructorDb!=null)
	    {
		Tecnologia tecnologiaDb=tecnologiaService.findById(
					        instructor_tecnologia.getTecnologia().getTecnologiaId());
		instructorDb.addTecnologia(tecnologiaDb);
			
		instructorService.insert(instructorDb);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	    }
		
	    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
