package com.schoolmanagement.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.schoolmanagement.helper.UserNotFoundException;
import com.schoolmanagement.model.Role;
import com.schoolmanagement.model.User;
import com.schoolmanagement.model.UserRole;
import com.schoolmanagement.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {	
		
		Role role=new Role();
		UserRole userRole=new UserRole();	
		
		Set<UserRole> roles=new HashSet<>();
		
		role.setRoleId(45L);
		role.setRoleName("NORMAL");		
			
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		
		User user2 = this.userService.createUser(user,roles);		
		return user2;	
		
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) {		
		User userById = this.userService.getUserById(id);
		return userById;
	}
	
	@GetMapping("/")
	public List<User> getAllUser(User user){		
		List<User> allUser = this.userService.getAllUser(user);
		return allUser;		
	}	

	@GetMapping("/{userName}")
	public User getUserByUserName(@PathVariable String userName) {		
		User userByName = this.userService.getUserbyUserName(userName);
		return userByName;
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		this.userService.deleteUser(id);
	}
	
	
//	public ResponseEntity<?> exceptionHandler(UserNotFoundException ex){
//		return ResponseEntity.
//	}
//	
		
}
