package com.freecharge.entities;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

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
	

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Integer id, String firstname, String lastname, String username, String email, String password,String mobileNumber,Date dob,Gender gender,Date createdDate,Date updatedDate,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobileNumber=mobileNumber;
		this.dob=dob;
		this.gender=gender;
		this.createdDate=createdDate;
		this.updatedDate=updatedDate;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getUid(), 
				user.getFirstname(),
				user.getLastname(),
				user.getUsername(), 
				user.getEmail(),
				user.getPassword(),
				user.getMobileNumber(),
				user.getDob(),
				user.getGender(),
				user.getCreatedDate(),
				user.getUpdatedDate(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public Date getDob() {
		return dob;
	}
	public Gender getGender() {
		return gender;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}

