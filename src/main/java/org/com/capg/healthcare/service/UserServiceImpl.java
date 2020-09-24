package org.com.capg.healthcare.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.com.capg.healthcare.dao.TestCenterRepository;
import org.com.capg.healthcare.dao.UserRepository;
import org.com.capg.healthcare.entity.DiagnosticCenter;
import org.com.capg.healthcare.entity.Test;
import org.com.capg.healthcare.entity.TestCenter;
import org.com.capg.healthcare.entity.User;
import org.com.capg.healthcare.exception.CenterNotFoundException;
import org.com.capg.healthcare.exception.NameAlreadyExistException;
import org.com.capg.healthcare.exception.TestNotFoundException;
import org.com.capg.healthcare.exception.UserNotFoundException;
import org.com.capg.healthcare.exception.UseralreadyExistException;
import org.com.capg.healthcare.util.TestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDao;
	
	
	
	/******************************************************************************************
	-Function Name            :     saveUser
	-Description              :     adding User to the  User Database Table using Spring Data
	-Input Parameters         :     User Object
	-Return Type              :     added user object
	-Throws                   :     UseralreadyExistException();
	-Author                   :     JYOTSNA
	-Created/Modified Date    :     19-09-20
	*******************************************************************************************/

	@Override
	public String addUser(User user) throws UseralreadyExistException {
		
		Optional<User> userId  = userDao.findById(user.getPhoneNo());
		
		if(userId.isPresent())
		{
			throw new UseralreadyExistException(TestConstants.USER_ALREADY_EXIST);
			
		}
		user.setPhoneNo(user.getPhoneNo());
		userDao.save(user);
		return TestConstants.USER_ADDED;
		
	}
	/******************************************************************************************
	-Function Name            :     removeUser
	-Description              :     removing User from the  User Database Table using Spring Data
	-Input Parameters         :     User Id
	-Return Type              :     String Showing whether user deleted or not
	-Throws                   :     UserNotFoundException();
	-Author                   :     JYOTSNA
	-Created/Modified Date    :     19-09-20
	*******************************************************************************************/
	
	@Override
	public String removeUser(Long PhoneNo) throws UserNotFoundException {
		
Optional<User> userId  = userDao.findById(PhoneNo);
		
		if(userId.isPresent())
		{
			userDao.deleteById(PhoneNo);
			return TestConstants.USER_DELETED;
			
		}
		else
		{
			return TestConstants.USER_NOT_FOUND;
		}


	}
	/******************************************************************************************
	-Function Name            :     getUser
	-Description              :     getting users from the  User Database Table using Spring Data
	-Input Parameters         :     User Id
	-Return Type              :     List of users type 
	-Throws                   :     none
	-Author                   :     JYOTSNA
	-Created/Modified Date    :     19-09-20
	*******************************************************************************************/

	@Override
	public List<User> getUser(Long userId){

	    	return userDao.findAll();   	
	    }

	/******************************************************************************************
	-Function Name            :     getUserById
	-Description              :     getting user from the  User Database Table using Spring Data
	-Input Parameters         :     User Id
	-Return Type              :      user object corresponding to the user id 
	-Throws                   :     none
	-Author                   :     JYOTSNA
	-Created/Modified Date    :     19-09-20
	*******************************************************************************************/
@Override
public ResponseEntity<User> getUserById(Long phoneNo) throws UserNotFoundException {
	User user=userDao.findById(phoneNo).
		   	 orElseThrow(() -> new UserNotFoundException(TestConstants.USER_NOT_FOUND));
		    	return ResponseEntity.ok().body(user);
}
}	




