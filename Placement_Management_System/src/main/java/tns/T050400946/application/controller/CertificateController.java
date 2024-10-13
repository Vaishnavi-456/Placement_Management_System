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
import tns.T050400946.application.services.CertificateService;

@RestController
public class CertificateController {
	
	@Autowired
	CertificateService service;
	
	@PostMapping("/certificates")
	void addCertificate(@RequestBody Certificate certificate) {
		service.addCertificate(certificate);
	}
	
	@GetMapping("/certificates/{certificate_id}")
	ResponseEntity<Certificate> searchCertificate(@PathVariable long certificate_id) {
		try
		{
			Certificate c=service.searchCertificate(certificate_id);
			return new ResponseEntity<>(c,HttpStatus.OK) ;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No record found");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/certificates/{certificate_id}")
	void deleteCertificate(@PathVariable long certificate_id) {
		service.deleteCertificate(certificate_id);
	}
	
	@PutMapping("certificates/{certificate_id}")
    public ResponseEntity<Certificate> updateCertificate(@RequestBody Certificate c, @PathVariable long certificate_id) {
        c.setCertificate_id(certificate_id); 
        Certificate updatedCertificate = service.updateCertificate(c);
        return new ResponseEntity<>(updatedCertificate, HttpStatus.OK);
    }

}
