package org.com.capg.healthcare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="abes_user")
public class User {
	
	@Id
	@Column(name = "phone_no")
	private long phoneNo;
	
	@Column(name = "user_name",length = 25)
	private String userName;
	
	@Column(name = "password" , length = 25)
	private String password;
	
	@Column(name = "gender", length = 25)
	private String gender;
	
	@Column(name = "email",length = 25)
	private String email;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "user_role", length = 25)
	private String userRole;

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	

	
	
	
}
