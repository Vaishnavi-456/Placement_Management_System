package tns.T050400946.application.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tns.T050400946.application.entities.User;
import tns.T050400946.application.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repo;
	
	private User loggedInUser;

	@Override
	public User addNewUser(User user) {
		 return repo.save(user);
	}

	@Override
	public User updateUser(User user) {
		if (!repo.existsById(user.getId())) {
	            throw new NoSuchElementException("User with ID " + user.getId() + " not found.");
	        }
	       
	        return repo.save(user);	}

	@Override
	public User login(User user) {
		 // Check if the user exists and credentials are valid
        User foundUser = repo.findByUsername(user.getUsername())
                .orElseThrow(() -> new NoSuchElementException("User not found with username: " + user.getUsername()));
        
        // Validate password 
        if (!foundUser.getPassword().equals(user.getPassword())) {
            throw new IllegalArgumentException("Invalid password.");
        }

        loggedInUser = foundUser; // Set the logged-in user
        System.out.println("User with ID:" + user.getId() + " logged in successfully ");
        return loggedInUser;
	}

	@Override
	public boolean logOut() {
		 if (loggedInUser != null) {
	            loggedInUser = null; 
	            System.out.println("User logged out successfully.");
	            return true; 
	        }
	        System.out.println("No user is currently logged in.");
	        return false; 
	} 
	
	@Override
	
	public User deleteUser(long id) {
		
		 User user = repo.findById(id)
		            .orElseThrow(() -> new NoSuchElementException("User with ID " + id + " not found."));

		    repo.delete(user); 
		    System.out.println("User with ID: " + id + " deleted successfully.");
		    
		    return user;
	}

	@Override
	public List<User> getAllUsers() {
		
		
		return repo.findAll();
	}
	
	
	
	
	

}
