package org.com.capg.healthcare.service;

import java.util.List;

import org.com.capg.healthcare.entity.TestCenter;
import org.com.capg.healthcare.exception.CenterNotFoundException;
import org.com.capg.healthcare.exception.NameAlreadyExistException;
import org.com.capg.healthcare.exception.TestNotFoundException;

public interface TestService {

	public String addTestToCenter(String centerId, String testId) throws TestNotFoundException,CenterNotFoundException,NameAlreadyExistException;
	
	public List<TestCenter> viewTests(String centerId) throws TestNotFoundException;
	
	public List<TestCenter> viewCenter(String testId) throws CenterNotFoundException; 
	
	
	
}
