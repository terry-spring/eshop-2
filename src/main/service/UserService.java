package main.service;

import main.model.User;

/**
 * η¨ζΆζε
 * @author sam
 *
 */
public interface UserService {

	public void createNewAccount(User user);
	
	public boolean loginExists(String login);
	
}
