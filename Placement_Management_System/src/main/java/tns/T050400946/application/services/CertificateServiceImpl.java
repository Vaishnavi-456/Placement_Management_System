package tns.T050400946.application.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tns.T050400946.application.entities.Certificate;
import tns.T050400946.application.repository.CertificateRepository;

@Service
public class CertificateServiceImpl implements CertificateService {
	
	@Autowired
	CertificateRepository repo;

	@Override
	public Certificate addCertificate(Certificate certificate) {
		
		return repo.save(certificate);
		
	}

	
	@Override
	public Certificate searchCertificate(long certificate_id) {
		
		 try {
			 
			 return repo.findById(certificate_id).get();			 
		 }catch(NoSuchElementException e) {
			 
			 System.out.println("No certificate found with ID: " + certificate_id);
			 return null;
			 
		 }
	}

	@Override
	public Certificate deleteCertificate(long certificate_id) {
		 Certificate certificate = searchCertificate(certificate_id); 
	     repo.deleteById(certificate_id);  // Delete the certificate
	     System.out.println("Certificate with ID: " + certificate_id + " deleted successfully.");
	     return certificate; 
	}


	@Override
	public Certificate updateCertificate(Certificate certificate) {
		
		if (!repo.existsById(certificate.getCertificate_id())) {
            throw new NoSuchElementException("Placement Information with ID " + certificate.getCertificate_id() + " not found.");
        }
        return repo.save(certificate); 
		
		
	}


	

}
