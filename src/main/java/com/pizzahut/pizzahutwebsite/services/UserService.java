package com.pizzahut.pizzahutwebsite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pizzahut.pizzahutwebsite.entity.UserEntity;
import com.pizzahut.pizzahutwebsite.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public UserEntity addUser(@ModelAttribute UserEntity ue) {

		return userRepository.save(ue);

	}

	public String deleteUser(Long userId) {
		UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
		user.setActive(0);
		userRepository.save(user);
		return "User deleted successfully";
	}

	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	public UserEntity updateUserById(Long userId, UserEntity ue) {
		UserEntity existing = userRepository.findById(userId).orElseThrow();
		existing.setUserName(ue.getUserName());
		existing.setAge(ue.getAge());
		existing.setEmail(ue.getEmail());

		return userRepository.save(existing);
	}
	
	public void getByEmai(String email) {
		// pending
	}
}
