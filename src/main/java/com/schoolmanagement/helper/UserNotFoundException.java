package com.schoolmanagement.helper;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String mg){		
		super(mg);
	}

}
