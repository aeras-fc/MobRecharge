package com.freecharge.jwt.payload.response;

import java.util.Date;
import java.util.List;

import com.freecharge.entities.Gender;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Integer id;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private String mobileNumber;
	private Date dob;
	private Gender gender;
	private Date createdDate;
	private Date updatedDate;
	
	private List<String> roles;

	public JwtResponse(String accessToken, Integer id, String firstname, String lastname, String username, String email, String mobileNumber, Date dob,Gender gender,Date createdDate,Date updatedDate, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.mobileNumber=mobileNumber;
		this.dob=dob;
		this.gender=gender;
		this.createdDate=createdDate;
		this.updatedDate=updatedDate;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<String> getRoles() {
		return roles;
	}
}
