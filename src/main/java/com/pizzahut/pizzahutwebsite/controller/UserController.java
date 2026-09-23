package com.pizzahut.pizzahutwebsite.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private UserService us;

	/*
	 * @Author : JeevanDobbala 
	 * for adding the user the below method is used
	 * expecting the json data and returns the Message if failed and if succeed it
	 * returns the user data
	 */
	@PostMapping("/adduser")
	public String addUser(@RequestBody UserEntity ue) {
		return us.addUser(ue);

	}

	
	/*
	 * @Author : JeevanDobbala 
	 * for deleting the user the below method is used
	 * expecting the json data and returns the Message if failed and if succeed it
	 * returns the user data
	 */
	@DeleteMapping("/deleteuser/{userId}")
	public String deleteUser(@PathVariable Long userId) {
		String s = us.deleteUser(userId);
		return s;

	}
	
	/*
	 * @Author : JeevanDobbala 
	 * for getting the user data with id the below method is used
	 * expecting the json data and returns the Message if failed and if succeed it
	 * returns the user data
	 */

	@GetMapping("/getuser/{userId}")
	public UserEntity getUserById(@PathVariable Long userId) {
		UserEntity user = new UserEntity();
		return user;
	}

	/*
	 * @Author : JeevanDobbala 
	 * for getting the all user information the below method is used
	 * expecting the json data and returns the Message if failed and if succeed it
	 * returns the user data
	 */
	@GetMapping("/getAll")
	public List<UserEntity> getAllUsers() {
		return us.getAllUsers();
	}

	/*
	 * @Author : JeevanDobbala 
	 * for updating the user info the below method is used
	 * expecting the json data and returns the Message if failed and if succeed it
	 * returns the user data
	 */
	@PutMapping("/updateUserById/{userId}")
	public UserEntity updateUserById(@PathVariable Long userId, @RequestBody UserEntity userEntity) {
		return us.updateUserById(userId, userEntity);
	}

	/*
	 * @Author : JeevanDobbala 
	 * for getting the user information with email the below method is used
	 * expecting the json data and returns the Message if failed and if succeed it
	 * returns the user data
	 */
	@GetMapping("/getByEmail/{email}")
	public ResponseEntity<?> getByEmail(@PathVariable String email) {

		Optional<UserEntity> user = us.getByEmail(email);

		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found with the given email");
	}
	/*
	 * @Author : JeevanDobbala 
	 * for deleting the user the below method is used
	 * expecting the json data and returns the Message if failed and if succeed it
	 * returns the user data
	 */
	@DeleteMapping("/deleteByEmail/{email}")
	public String deleteByEmail(@PathVariable String email) {

		Optional<UserEntity> user = us.getByEmail(email);

		if (user.isPresent()) {
			us.deleteByEmail(email);
			return "user deleted Successfully!";
		}

		return "user not found with given email!";
	}

}
