package com.skilldistillery.tudorjpa.data;

import java.util.List;

import com.skilldistillery.tudorjpa.entities.User;

public interface TutDAOUser {
	
	public List<User> findAllUsers();
	public List<User> findAllActiveUsers();
	public List<User> findAllInactiveUsers();
	public User createUser(User user);
	public User updateUser(int id, User user);
	public User findUserById(int id);
	public boolean deleteUser(int id);
	public User validateUsernameAndPassword(String userName, String password);

}
