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
import tns.T050400946.application.entities.Placement;
import tns.T050400946.application.services.PlacementService;


@RestController
public class PlacementController {
	
	@Autowired
	PlacementService service;
	
	@PostMapping("/placements")
	void addPlacement(@RequestBody Placement placement) {
		service.addPlacement(placement);
	}
	
	@GetMapping("/placements/{id}")
	ResponseEntity<Placement> searchPlacement(@PathVariable long id) {
		try
		{
			Placement p=service.searchPlacement(id);
			return new ResponseEntity<>(p,HttpStatus.OK) ;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No record found");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@DeleteMapping("/placements/{id}")
	void cancelPlacement(@PathVariable long id) {
		service.cancelPlacement(id);
	}
	
	@PutMapping("placements/{id}")
    public ResponseEntity<Placement> updatePlacement(@RequestBody Placement p, @PathVariable long id) {
        p.setId(id); 
        Placement updatedPlacement = service.updatePlacement(p);
        return new ResponseEntity<>(updatedPlacement, HttpStatus.OK);
    }


}