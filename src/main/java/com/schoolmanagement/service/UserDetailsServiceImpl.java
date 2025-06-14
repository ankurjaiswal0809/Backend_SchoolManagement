package com.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.schoolmanagement.helper.UserNotFoundException;
import com.schoolmanagement.model.User;
import com.schoolmanagement.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User User = this.repository.findByUserName(username);
		if(User==null) {
			System.out.println("Username is not available!");
			throw new UserNotFoundException("User Not Found!");
		}		
		return User;
	}

}
