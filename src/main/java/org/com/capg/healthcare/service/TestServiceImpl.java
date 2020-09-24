package org.com.capg.healthcare.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.com.capg.healthcare.dao.DiagnosticCenterRepository;
import org.com.capg.healthcare.dao.TestCenterRepository;
import org.com.capg.healthcare.dao.TestRepository;
import org.com.capg.healthcare.entity.DiagnosticCenter;
import org.com.capg.healthcare.entity.Test;
import org.com.capg.healthcare.entity.TestCenter;
import org.com.capg.healthcare.exception.CenterNotFoundException;
import org.com.capg.healthcare.exception.NameAlreadyExistException;
import org.com.capg.healthcare.exception.TestNotFoundException;
import org.com.capg.healthcare.util.TestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TestServiceImpl implements TestService{

	@Autowired
	private TestRepository testDao;
	
	
	@Autowired
	private DiagnosticCenterRepository diagnosticDao;
	

	@Autowired
	private TestCenterRepository testCenterDao;
	
	@Override
	public String addTestToCenter(String centerId, String testId)
			throws TestNotFoundException, CenterNotFoundException, NameAlreadyExistException {
		
	Optional<Test> opttest  = testDao.findById(testId);
	
	if(!opttest.isPresent())
	{
		throw new TestNotFoundException(TestConstants.TEST_NOT_FOUND);
		
	}
	
	Optional<DiagnosticCenter> optcenter= diagnosticDao.findById(centerId);
	if(!optcenter.isPresent())
	{
		throw new CenterNotFoundException(TestConstants.CENTER_NOT_FOUND);
	}
	
	
	
	TestCenter testCenter = new TestCenter();
	DiagnosticCenter center = optcenter.get();
	Test test = opttest.get();
	
	Optional<TestCenter> opttestcenter = testCenterDao.findById(center.getCenterId()+test.getTestId());
	
	if(opttestcenter.isPresent())
	{
		throw new NameAlreadyExistException(TestConstants.NAME_ALREADY_EXIST);
	}
	
	testCenter.setTestCenterId(center.getCenterId()+test.getTestId());
    testCenter.setCenter(center);
    testCenter.setTest(test);
    
    testCenterDao.save(testCenter);
    
    return TestConstants.TEST_ADDED;
		
	}

	@Override
	public List<TestCenter> viewTests(String centerId) throws TestNotFoundException {

		List<TestCenter> testList = testCenterDao.viewTest(centerId);
		
		if(testList.isEmpty())
		{
			throw new TestNotFoundException(TestConstants.TEST_NOT_FOUND);
		}
		
		testList.sort((t1,t2)->t1.getTest().getTestName().compareTo(t2.getTest().getTestName()));
		
		return testList;
	}

	@Override
	public List<TestCenter> viewCenter(String testId) throws CenterNotFoundException {
		
List<TestCenter> centerList = testCenterDao.viewCenter(testId);
		
		if(centerList.isEmpty())
		{
			throw new CenterNotFoundException(TestConstants.CENTER_NOT_FOUND);
		}
		
		centerList.sort((t1,t2)->t1.getCenter().getCenterName().compareTo(t2.getCenter().getCenterName()));
		
		return centerList;
		
		
	}
	

}
