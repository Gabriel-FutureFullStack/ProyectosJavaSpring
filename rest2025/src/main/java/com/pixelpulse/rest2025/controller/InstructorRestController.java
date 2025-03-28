package com.pixelpulse.rest2025.controller;
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
import com.pixelpulse.rest2025.model.Instructor;
import com.pixelpulse.rest2025.service.InstructorService;
 

@RestController
@RequestMapping("/api/v1")
public class InstructorRestController {
	
	private InstructorService instructorService;
	public InstructorRestController(InstructorService instructorService) {
		this.instructorService = instructorService;
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		Collection<Instructor> itemsInstructor=instructorService.findAll();		
		return new ResponseEntity<>(itemsInstructor,HttpStatus.OK); 
	}
	
	@GetMapping("/buscar/{instructorId}")
	public ResponseEntity<?> buscar(@PathVariable Long instructorId) {
		Instructor instructor=instructorService.findById(instructorId);		
		if(instructor!=null) {
			return new ResponseEntity<>(instructor,HttpStatus.OK); 
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Instructor instructor) {
		instructorService.insert(instructor);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); 
	}
 
	@PutMapping("/editar/{instructorId}")
	public ResponseEntity<?> editar(@PathVariable Long instructorId,
                                        @RequestBody Instructor newInstructor) {		
		Instructor instructor=instructorService.findById(instructorId);		
		if(instructor!=null) {
			instructor.setName(newInstructor.getName());
			instructor.setLastName(newInstructor.getLastName());
			instructor.setPassword(newInstructor.getPassword());
			instructor.setEmail(newInstructor.getEmail());
			instructor.setDateReg(newInstructor.getDateReg());		
			instructorService.update(instructor);			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
 
	@DeleteMapping("/borrar/{instructorId}") 
	public ResponseEntity<?> borrar(@PathVariable Long instructorId)
	{
		Instructor instructor=instructorService.findById(instructorId);
		
		if(instructor!=null) {
			instructorService.delete(instructorId);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
}
