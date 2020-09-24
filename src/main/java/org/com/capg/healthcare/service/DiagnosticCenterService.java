package org.com.capg.healthcare.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.com.capg.healthcare.dao.DiagnosticCenterRepository;
import org.com.capg.healthcare.dao.TestRepository;
import org.com.capg.healthcare.entity.DiagnosticCenter;
import org.com.capg.healthcare.entity.Test;

import org.com.capg.healthcare.exception.CenterNotFoundException;
import org.com.capg.healthcare.exception.NameAlreadyExistException;

@Service
public class DiagnosticCenterService {

	private static final String CENTER_DELETED = "Center deleted successfully";

	private static final String INVALID_ID = "Invalid centerId passed";

	@Autowired
	DiagnosticCenterRepository centerRepo;
	
	@Autowired
	TestRepository testRepo;
	
	
	
	/******************************************************************************************
	-Function Name            :     saveDiagnosticCenter
	-Description              :     adding Center to the Diagnostic Center Database Table using Spring Data
	-Input Parameters         :     Diagnostic Center Object
	-Return Type              :     added Center object
	-Throws                   :     CenterNameAlreadyExistException();
	-Author                   :     AKRITI
	-Created/Modified Date    :     19-09-2020
	 * @throws CenterNameAlreadyExistException 
	*******************************************************************************************/
	
	public DiagnosticCenter saveDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws NameAlreadyExistException {
		if(centerRepo.getByCenterName(diagnosticCenter.getCenterName())!=null) {
			throw new NameAlreadyExistException("Center with Name"+diagnosticCenter.getCenterName()+" Already Exist");
		
		}
		String centerAddress= diagnosticCenter.getCenterAddress();
		System.out.println(centerAddress);
		return centerRepo.save(diagnosticCenter);
		
	}
	
	/********************************************************************************************
	-Function Name            :     deleteCenter
	-Description              :     delete Center from the Diagnostic Center Database Table
	-Input Parameters         :     Diagnostic Center Id
	-Return Type              :     String showing whether deleted or not
	-Throws                   :     CenterNotFoundException();
	-Author                   :     AKRITI
	-Created/Modified Date    :     20-09-2020
	*******************************************************************************************/
	
	public String deleteDiagnosticCenter(String centerId) throws CenterNotFoundException
    {
	 Optional<DiagnosticCenter> findById = centerRepo.findById(centerId);
		if (findById.isPresent()) {
			centerRepo.deleteById(centerId);
			return CENTER_DELETED;
		} else {
			return INVALID_ID;
		}
    }
	
	/********************************************************************************************
	-Function Name            :     updateDiagnosticCenter
	-Description              :     update the details of center
	-Input Parameters         :     Diagnostic Center Object
	-Return Type              :     Diagnostic Center Object
	-Throws                   :     CenterNotFoundException()
	-Author                   :     AKRITI
	-Created/Modified Date    :     20-09-2020
	*******************************************************************************************/
	
	public ResponseEntity<DiagnosticCenter> updateDiagnosticCenter( @RequestBody DiagnosticCenter diagnosticCenter)
	{
//		Optional<DiagnosticCenter> findById=centerRepo.findById(diagnosticCenter.getCenterId());
//		try {
//			if(findById.isPresent())
//			{
//				centerRepo.save(diagnosticCenter);
//				return new ResponseEntity<DiagnosticCenter>(diagnosticCenter,HttpStatus.OK);		
//			}
//			else {
//				throw new CenterNotFoundException("Center not present");
//				}
//			}catch(CenterNotFoundException e) {
//					return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
//		    }
		return null;
     }

	/******************************************************************************************
	-Function Name            :     getAllCenters
	-Description              :     getting Centers from the Diagnostic Center Database Table using Spring Data
	-Input Parameters         :     Diagnostic Center Id only
	-Return Type              :     Diagnostic Center object corresponding to the given Id
	-Author                   :     AKRITI
	-Created/Modified Date    :     19-09-2020
	*********************************************************************************************/
	
	
	public List<DiagnosticCenter> getAllCenters(BigInteger centerId){
    	return centerRepo.findAll();   	
    }
 
	
	/******************************************************************************************
	-Function Name            :     getCenterById
	-Description              :     getting Center from the Diagnostic Center Database Table using Spring Data
	-Input Parameters         :     Diagnostic Center Id only
	-Return Type              :     Center object corresponding to the given Id
	-Throws                   :     CenterNotFoundException();
	-Author                   :     AKRITI
	-Created/Modified Date    :     19-09-2020
	 * @throws CenterNotFoundException 
	*********************************************************************************************/
	
	public ResponseEntity<DiagnosticCenter> getCenterById(String centerId) throws CenterNotFoundException {
		DiagnosticCenter center=centerRepo.findById(centerId).
			   	 orElseThrow(() -> new CenterNotFoundException("Center not found for the given id " +centerId));
			    	return ResponseEntity.ok().body(center);
	}	
		

	
	
	
	
}
		
	
		
		
		
