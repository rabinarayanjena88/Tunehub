package com.kodnest.tunehub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String username;
	private String password;
	private String mobilenumber;
	private String email;
	private String gender;
	private String role;
	private String address;
	private boolean premium;
	
	public User() {
		super();
		
	}

	public User(int userid, String username, String password, String mobilenumber, String email, String gender,
			String role, String address, boolean premium) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.mobilenumber = mobilenumber;
		this.email = email;
		this.gender = gender;
		this.role = role;
		this.address = address;
		this.premium = premium;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", mobilenumber="
				+ mobilenumber + ", email=" + email + ", gender=" + gender + ", role=" + role + ", address=" + address
				+ ", premium=" + premium + "]";
	}
	
	
	
}
