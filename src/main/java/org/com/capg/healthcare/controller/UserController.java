package org.com.capg.healthcare.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.com.capg.healthcare.dto.SuccessMessage;
import org.com.capg.healthcare.entity.User;
import org.com.capg.healthcare.exception.CenterNotFoundException;
import org.com.capg.healthcare.exception.NameAlreadyExistException;
import org.com.capg.healthcare.exception.TestNotFoundException;
import org.com.capg.healthcare.exception.UserNotFoundException;
import org.com.capg.healthcare.exception.UseralreadyExistException;
import org.com.capg.healthcare.service.UserService;
import org.com.capg.healthcare.service.UserServiceImpl;
import org.com.capg.healthcare.util.TestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userservice;
	
	
	@GetMapping(TestConstants.USER_ADD_URL)
	public SuccessMessage addUser(@RequestBody User user) throws UseralreadyExistException {
		
		return new SuccessMessage(userservice.addUser(user));
	}
	
	@GetMapping(TestConstants.USER_DELETE_URL)
	public SuccessMessage removeUser(@PathVariable(value="userId") Long userId) throws UserNotFoundException {
		
		return new SuccessMessage(userservice.removeUser(userId));
	}
	
	@GetMapping(TestConstants.VIEW_ALL_USERS_URL)
	public List<User> getAllUsers(Long userId) {

		return userservice.getUser(userId);

	}
	
	@GetMapping(TestConstants.VIEW_USER_URL)
	public ResponseEntity<User> getDiagnosticCenter(@PathVariable Long phoneNo)throws UserNotFoundException
	{
		return userservice.getUserById(phoneNo);
	}

		
	}
	
