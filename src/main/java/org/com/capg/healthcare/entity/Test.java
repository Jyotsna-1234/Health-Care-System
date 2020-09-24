package org.com.capg.healthcare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "abes_test")
public class Test {
	
	
	
	/*******************************************************************************************************************************
	-Author                   :     Aastik Srivastava
	-Created/Modified Date    :     20-09-2020
	-Description              :     Test Bean Class
	*******************************************************************************************************************************/

	
	
	@Id
	
	@Column(name = "test_id", length = 10)
	public String testId;
	
	@Column(name = "test_name", length = 25)
	private String testName;
	
	@Column(name = "test_details")
	private String testDetails;

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestDetails() {
		return testDetails;
	}

	public void setTestDetails(String testDetails) {
		this.testDetails = testDetails;
	}
	
	
	
	
	
	

	
}
