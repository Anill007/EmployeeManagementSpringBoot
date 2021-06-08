package com.anil.employeemanager.myexceptions;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String m) {
		super(m);	
	}
}
