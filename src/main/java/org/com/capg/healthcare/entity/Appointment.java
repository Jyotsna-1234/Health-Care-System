package org.com.capg.healthcare.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "abes_appointment")
public class Appointment {
	
	@Id
	@Column(name = "appointment_id")
	private String appointmentId;
	
	@Column(name = "date_of_booking")
	private LocalDate dateOfBooking;
	
	@ManyToOne
	@JoinColumn(name = "scheduled_id")
	private ScheduledAppointments scheduled;
	
	@Column(name = "status")
	private String status;
	
	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(LocalDate dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public ScheduledAppointments getScheduled() {
		return scheduled;
	}

	public void setScheduled(ScheduledAppointments scheduled) {
		this.scheduled = scheduled;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "phone_no")
	private User user;

	
	
	
	
	
	
	
	
}
