package tns.T050400946.application.controller;

import java.util.List;

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

import tns.T050400946.application.entities.User;
import tns.T050400946.application.repository.UserRepository;
import tns.T050400946.application.services.UserService;

@RestController
public class UserController {

    @Autowired
    UserService service;
    
   

    // Add a new user
    @PostMapping("/users")
    public ResponseEntity<String> addNewUser(@RequestBody User user) {
        service.addNewUser(user);
        return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
    }

    // Update an existing user
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
        user.setId(id); // Set the ID in the User object
        User updatedUser = service.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Login user
    @PostMapping("/users/{id}/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User loggedInUser = service.login(user);
        return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
    }

    // Logout user
    @PostMapping("/users/{id}/logout")
    public ResponseEntity<String> logOut() {
        boolean isLoggedOut = service.logOut();
        return isLoggedOut 
                ? new ResponseEntity<>("User logged out successfully", HttpStatus.OK)
                : new ResponseEntity<>("No user is currently logged in", HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    } 

    // Delete user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        User deletedUser = service.deleteUser(id);
        return new ResponseEntity<>("User with ID: " + deletedUser.getId() + " deleted successfully", HttpStatus.OK);
    }
}
