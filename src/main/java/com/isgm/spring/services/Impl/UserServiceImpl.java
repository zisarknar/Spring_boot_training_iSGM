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

	@Override
	public void removeBtId(int id) {
		mRepository.deleteById((long) id);
	}

	@Override
	public void addNewUser(User user) {
		mRepository.saveAndFlush(user);
		
	}

	@Override
	public void update(User oldUser) {
		mRepository.saveAndFlush(oldUser);
	}

}
