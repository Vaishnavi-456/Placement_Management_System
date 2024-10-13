package tns.T050400946.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tns.T050400946.application.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	

}
