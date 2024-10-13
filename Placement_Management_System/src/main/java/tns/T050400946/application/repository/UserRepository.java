package tns.T050400946.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tns.T050400946.application.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	 // Method to find a user by username
    Optional<User> findByUsername(String username);
	

}
