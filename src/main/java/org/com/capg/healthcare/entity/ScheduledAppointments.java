package org.com.capg.healthcare.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "abes_scheduled_appointments")
public class ScheduledAppointments {

	@Id
	@Column(name ="scheduled_id", length = 10)
	private String scheduledId;
	
	@Column(name = "appointments")
	private int appointments;
	
	@Column(name = "test_cost")
	private double testCost;
	
	@Column(name="date_of_appointment")
	private LocalDate dateOfAppointment;
	
	@ManyToOne
	@JoinColumn(name = "test_center_id")
	private TestCenter testCenter;

	public String getScheduledId() {
		return scheduledId;
	}

	public void setScheduledId(String scheduledId) {
		this.scheduledId = scheduledId;
	}

	public int getAppointments() {
		return appointments;
	}

	public void setAppointments(int appointments) {
		this.appointments = appointments;
	}

	public double getTestCost() {
		return testCost;
	}

	public void setTestCost(double testCost) {
		this.testCost = testCost;
	}

	public LocalDate getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(LocalDate dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public TestCenter getTestCenter() {
		return testCenter;
	}

	public void setTestCenter(TestCenter testCenter) {
		this.testCenter = testCenter;
	}
	
	
	

}
