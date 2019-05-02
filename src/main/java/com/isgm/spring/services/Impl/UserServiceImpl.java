package com.isgm.spring.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isgm.spring.entities.User;
import com.isgm.spring.repositories.UserRepository;
import com.isgm.spring.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository mRepository;

	@Override
	public List<User> getAllUsers() {
		return mRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		return mRepository.getOne((long) id);
	}

}
