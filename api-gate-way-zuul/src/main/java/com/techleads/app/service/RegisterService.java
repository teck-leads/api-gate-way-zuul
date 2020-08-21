package com.techleads.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techleads.app.model.User;
import com.techleads.app.repository.UserRepository;

@Service
public class RegisterService {
	@Autowired
	private UserRepository userRepository;

	public void registerUser(User user) {

		User save = userRepository.save(user);
		System.out.println(save);
	}

	public User findByUsername(String userName) {

		User findByUsername = userRepository.findByUsername(userName);
		if (findByUsername == null) {
			return new User();
		} else {
			return findByUsername;
		}

	}

}
