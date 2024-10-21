package tns.T050400946.application.services;

import java.util.List;

import tns.T050400946.application.entities.User;

public interface UserService {
	
	User addNewUser(User user);
	User updateUser(User user);
	User login(User user);
	boolean logOut();
	User deleteUser(long id);
	List<User> getAllUsers();

}
