package com.wehago.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wehago.repository.User;
import com.wehago.service.UserService;

@RestController
public class DemoRestController {
	static final Logger logger = LoggerFactory.getLogger(DemoRestController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	ResponseEntity<?> index(){
		return new ResponseEntity<>("<h1>Hello World1</h1>", HttpStatus.OK);
	}
	
	@GetMapping("/user/users")
	ResponseEntity<?> userList(){		
		List<User> users = userService.userList();
		logger.debug("users : {} ", users);
        return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	ResponseEntity<?> getUser(@PathVariable Long id){
		User user = userService.getUser(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/user/insert")
	ResponseEntity<?> insertUser(){		
		User user = userService.insertUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/user/delete/{id}")
	ResponseEntity<?> deleteUser(@PathVariable Long id){		
		userService.deleteUser(id);
		return new ResponseEntity<>("<h1>Deleted["+ id +"]</h1>", HttpStatus.OK);
	}
	
	@GetMapping("/error")
	ResponseEntity<?> error(){
		return new ResponseEntity<>("<h1>Error</h1>", HttpStatus.OK);
	}
}
