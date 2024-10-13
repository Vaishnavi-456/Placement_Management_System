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

import tns.T050400946.application.entities.College;
import tns.T050400946.application.services.CollegeService;

@RestController
public class CollegeController {
	
	@Autowired
	CollegeService service;
	
	@PostMapping("/colleges")
	void addCollege(@RequestBody College college) {
		service.addCollege(college);
	}
	
	@GetMapping("/colleges/{college_id}")
	ResponseEntity<College> searchCollege(@PathVariable long college_id) {
		try
		{
			College c=service.searchCollege(college_id);
			return new ResponseEntity<>(c,HttpStatus.OK) ;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No record found");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/colleges/{college_id}")
	void deleteCollege(@PathVariable long college_id) {
		service.deleteCollege(college_id);
	}
	
	@PutMapping("colleges/{college_id}")
    public ResponseEntity<College> updateCollege(@RequestBody College c, @PathVariable long college_id) {
        c.setCollege_id(college_id); 
        College updatedCollege = service.updateCollege(c);
        return new ResponseEntity<>(updatedCollege, HttpStatus.OK);
    }


}