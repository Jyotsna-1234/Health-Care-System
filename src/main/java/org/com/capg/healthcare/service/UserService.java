package org.com.capg.healthcare.service;

	import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.com.capg.healthcare.entity.TestCenter;
	import org.com.capg.healthcare.entity.User;
	import org.com.capg.healthcare.exception.CenterNotFoundException;
	import org.com.capg.healthcare.exception.NameAlreadyExistException;
	import org.com.capg.healthcare.exception.TestNotFoundException;
	import org.com.capg.healthcare.exception.UserNotFoundException;
import org.com.capg.healthcare.exception.UseralreadyExistException;
import org.springframework.http.ResponseEntity;

		
		public interface UserService {

			public String addUser(User user) throws UseralreadyExistException;
			public String removeUser(Long PhoneNo) throws UserNotFoundException ;
			public List<User> getUser(Long userId);
			public ResponseEntity<User> getUserById(Long phoneNo) throws UserNotFoundException ;


		
	}



