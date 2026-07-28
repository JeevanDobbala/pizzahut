package com.pizzahut.pizzahutwebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzahut.pizzahutwebsite.entity.UserEntity;
import com.pizzahut.pizzahutwebsite.services.UserService;

//@CrossOrigin("http://localhost:4200/")
@RestController
public class UserController {
	
	@Autowired
	UserService us;
	
	@PostMapping("/adduser")
	public UserEntity addUser(@RequestBody UserEntity ue) {
	    us.addUser(ue);
		return ue ;
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public String deleteUser(@PathVariable Long userId) {
		String s=us.deleteUser(userId);
		return s;
		
	}
	
	@GetMapping("/getuser/{userId}")
	public UserEntity getUserById(@PathVariable Long userId){
		UserEntity user= new UserEntity();
		return user;
	}
	
	@GetMapping("/getAll")
	public List<UserEntity> getAllUsers(){
		return us.getAllUsers();
	}
	
	@PutMapping("/updateUserById/{userId}")
	public UserEntity updateUserById(@PathVariable Long userId , @RequestBody UserEntity userEntity) {
		return us.updateUserById(userId ,userEntity);
	}
	

}
