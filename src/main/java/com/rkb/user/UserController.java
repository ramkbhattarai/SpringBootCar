package com.rkb.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUser(){
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.findById(id);
	}
	
	@PostMapping
	public User saveUser(@RequestBody User u) {
		return userService.upsert(u);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.delete(id);
	}

}
