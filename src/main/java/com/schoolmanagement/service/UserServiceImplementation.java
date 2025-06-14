package com.schoolmanagement.service;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.repository.RoleRepository;
import com.examportal.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRole) throws Exception {
		
		User local=this.userRepository.findByUserName(user.getUserName());		
		if(local!=null) {
			System.out.println("User is already created!!");
			throw new Exception("User id already present");			
		}		
		else {			
			for(UserRole ur: userRole) {				
				this.roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRole);
			local=this.userRepository.save(user);			
		}		
		return local;
	}

	@SuppressWarnings("deprecation")
	@Override
	public User getUserById(Long id) {		
		User byId = this.userRepository.findById(id).orElseThrow();
		return byId;
	}

	@Override
	public List<User> getAllUser(User user) {
		List<User> all = this.userRepository.findAll();
		return all;
	}

	@Override
	public User getUserbyUserName(String userName) {
		User byUserName = this.userRepository.findByUserName(userName);
		return byUserName;
	}

	@Override
	public void deleteUser(Long id) {
		this.userRepository.deleteById(id);
		
	}

	@Override
	public User updateUser(User user) {
		
		return null;
	}

}
