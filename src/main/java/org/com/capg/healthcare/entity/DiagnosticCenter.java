package org.com.capg.healthcare.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "diagnostic_center")
public class DiagnosticCenter {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "center_id", length = 25)
	private String centerId;
	
	@Column(name = "center_name" , length = 25)
	private String centerName;
	
	@Column(name = "center_address" , length = 50) 
	private String centerAddress;
	
	@Column(name = "contact_number" , length = 10 )
	private String contactNumber;
	
	
	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setCenterName(String diagnosticCenterName) {
		this.centerName = diagnosticCenterName;
	}
	
	public String getCenterAddress() {
		return centerAddress;
	}
	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}

	@Override
	public String toString() {
		return "DiagnosticCentre [diagnosticCentreId=" + centerId + ", centreName=" + 
	centerName + ", centreAddress=" + centerAddress + "]";
	}
}
