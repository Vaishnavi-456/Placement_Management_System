package tns.T050400946.application.controller;



import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tns.T050400946.application.entities.Certificate;
import tns.T050400946.application.entities.Student;
import tns.T050400946.application.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/students")
	void addStudent(@RequestBody Student student) {
		service.addStudent(student);
	}
	
	@GetMapping("/students/id/{id}")
	ResponseEntity<Student> searchStudentById(@PathVariable long id) {
		try
		{
			Student s=service.searchStudentById(id);
			return new ResponseEntity<>(s,HttpStatus.OK) ;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No record found");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/students/hallTicket/{ticketNo}")
	ResponseEntity<Student> searchStudentByHallTicket(@PathVariable long ticketNo) {
		try
		{
			Student s=service.searchStudentById(ticketNo);
			return new ResponseEntity<>(s,HttpStatus.OK) ;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No record found");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/students/{id}")
	void deleteStudent(@PathVariable long id) {
		service.deleteStudent(id);
	}
	
	@PutMapping("/students/{id}")
    public ResponseEntity<Student> studentPlacement(@RequestBody Student s, @PathVariable long id) {
        s.setId(id); 
        Student updatedStudent = service.updateStudent(s);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }
	
	 @PostMapping("/students/{id}/certificate")
	    public ResponseEntity<String> addCertificate(@PathVariable long id, @RequestBody Certificate certificate) {
	        boolean added = service.addCertificate(certificate);
	        return added
	                ? new ResponseEntity<>("Certificate added successfully", HttpStatus.OK)
	                : new ResponseEntity<>("Failed to add certificate", HttpStatus.BAD_REQUEST);
	    }

	    
	    @PutMapping("/students/{id}/certificate")
	    public ResponseEntity<String> updateCertificate(@PathVariable long id, @RequestBody Certificate certificate) {
	        // Set the student ID or any other necessary fields in the certificate
	    	 Student student = service.searchStudentById(id);
	        certificate.setStudent(student); 
	        boolean updated = service.updateCertificate(certificate);
	        return updated
	                ? new ResponseEntity<>("Certificate updated successfully", HttpStatus.OK)
	                : new ResponseEntity<>("Failed to update certificate", HttpStatus.BAD_REQUEST);
	    }

}
