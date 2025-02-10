package org.dnyayog.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserResponse {
	private String responceCode;
	private String responceMessage;
	
	private List<User>users;
	
	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getResponceCode() {
		return responceCode;
	}

	public void setResponceCode(String responceCode) {
		this.responceCode = responceCode;
	}

	public String getResponceMessage() {
		return responceMessage;
	}

	public void setResponceMessage(String responceMessage) {
		this.responceMessage = responceMessage;
	}



}
