package tns.T050400946.application.services;

import java.util.List;

import tns.T050400946.application.entities.Certificate;
import tns.T050400946.application.entities.Student;
import tns.T050400946.application.entities.User;

public interface StudentService {
	
	Student addStudent(Student student);
	Student updateStudent(Student student);
	Student searchStudentById(long id);
	Student searchStudentByHallTicket(long ticketNo);
	boolean addCertificate(Certificate certificate);
	boolean updateCertificate(Certificate certificate);
	boolean deleteStudent(long id);
	List<Student> getAllStudents();
	

}
