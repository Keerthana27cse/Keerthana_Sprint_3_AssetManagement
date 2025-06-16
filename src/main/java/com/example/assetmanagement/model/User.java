package com.example.assetmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class User {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	private String username; 
	private String password; 
	private String email; 
	@Enumerated(EnumType.STRING) 
	private UserRole userrole;
	public Long getId() {
		return id;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	} 
	public User(Long id, String username, String password, String email, UserRole userrole) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userrole = userrole;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRole getRole() {
		return userrole;
	}
	public void setRole(UserRole userrole) {
		this.userrole = userrole;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", role="
				+ userrole + "]";
	}
}
	
	

