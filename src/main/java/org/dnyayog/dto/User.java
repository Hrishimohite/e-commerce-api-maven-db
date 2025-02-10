package org.dnyayog.dto;

import org.springframework.stereotype.Component;

@Component
public class User {
	private String number;
	private String username;
	private String email;
	
	
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
