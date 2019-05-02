package com.isgm.spring.services;

import java.util.List;

import com.isgm.spring.entities.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	User getUserById(int id);
	

}
