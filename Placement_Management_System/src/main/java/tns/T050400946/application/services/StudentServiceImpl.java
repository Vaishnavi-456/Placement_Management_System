package tns.T050400946.application.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tns.T050400946.application.entities.Certificate;
import tns.T050400946.application.entities.Student;
import tns.T050400946.application.repository.CertificateRepository;
import tns.T050400946.application.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository repo;
	
	@Autowired
	CertificateRepository repo1;

	@Override
	public Student addStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		if (!repo.existsById(student.getId())) {
            throw new NoSuchElementException("Student with ID " + student.getId() + " not found.");
        }
        return repo.save(student);  
	}

	@Override
	public Student searchStudentById(long id) {
		
         try {
			
			return repo.findById(id).get();
			
		}catch(NoSuchElementException e) {
			
			System.out.println("No student found with ID: " + id);
			return null;
		}
	}

	@Override
	public Student searchStudentByHallTicket(long ticketNo) {
         try {
			
			return repo.findById(ticketNo).get();
			
		 }catch(NoSuchElementException e) {
			
			System.out.println("No student found with ID: " + ticketNo);
			return null;
		}
	}

	@Override
	public boolean addCertificate(Certificate certificate) {
		Certificate savedCertificate = repo1.save(certificate);
        return savedCertificate != null; 
	}

	@Override
	public boolean updateCertificate(Certificate certificate) {
		
		if (!repo1.existsById(certificate.getCertificate_id())) {
            throw new NoSuchElementException("Certificate with ID " + certificate.getCertificate_id() + " not found.");
        }
        repo1.save(certificate); 
        return true;  
	}

	@Override
	public boolean deleteStudent(long id) {
		
		 if (!repo.existsById(id)) {
	            throw new NoSuchElementException("Student with ID " + id + " not found.");
	        }
	        repo.deleteById(id);
	        System.out.println("Student with ID: " + id + " deleted successfully.");
	        return true; 
		
		
		
	}

}
