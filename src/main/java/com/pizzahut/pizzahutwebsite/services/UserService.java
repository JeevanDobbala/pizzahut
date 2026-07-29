package com.pizzahut.pizzahutwebsite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pizzahut.pizzahutwebsite.entity.UserEntity;
import com.pizzahut.pizzahutwebsite.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public String addUser(@ModelAttribute UserEntity ue) {
		String status = "";
		UserEntity v = userRepository.findByEmail(ue.getEmail()).orElse(null);
		if (v == null) {
			userRepository.save(ue);
			status = "user added successfully!";
		} else {
			status = "user with this email already exists!";
		}
		return status;

	}

	public String deleteUser(Long userId) {
		UserEntity user = userRepository.findById(userId).orElse(null);
		if (user == null) {
			return "no user exists with given Id !";
		}
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

	public Optional<UserEntity> getByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public String deleteByEmail(String email) {
		String status = "";
		UserEntity existing = userRepository.findByEmail(email).orElseThrow();
		existing.setActive(0);
		UserEntity v = userRepository.save(existing);
		if (v.getActive() == 0 && v != null) {
			status = "deleted successfully!";
		} else {
			status = "something went wrong!";
		}
		return status;
	}
}
