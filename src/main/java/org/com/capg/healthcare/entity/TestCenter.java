package org.com.capg.healthcare.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "abes_test_center")
public class TestCenter {
	
	@Id
	@Column(name = "test_center_id")
	private String testCenterId;
	
	@ManyToOne
	@JoinColumn(name = "center_id")
	private DiagnosticCenter center;
	
	@ManyToOne
	@JoinColumn(name = "test_id")
	private Test test;

	public String getTestCenterId() {
		return testCenterId;
	}

	public void setTestCenterId(String testCenterId) {
		this.testCenterId = testCenterId;
	}

	public DiagnosticCenter getCenter() {
		return center;
	}

	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	
	

}
