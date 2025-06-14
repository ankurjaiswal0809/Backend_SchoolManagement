package com.schoolmanagement.service;

import java.util.List;
import java.util.Set;

import com.schoolmanagement.model.User;
import com.schoolmanagement.model.UserRole;

public interface UserService {
	
	public User createUser(User user, Set<UserRole> userRole) throws Exception;
	
	public User getUserById(Long id);
	
	public List<User> getAllUser(User user);
	
	public User getUserbyUserName(String userName);
	
	public void deleteUser(Long id);
	
	public User updateUser(User user);

}
