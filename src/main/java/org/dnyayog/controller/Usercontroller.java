package org.dnyayog.controller;

import java.sql.SQLException;

import org.dnyayog.dto.UserRequest;
import org.dnyayog.dto.UserResponse;
import org.dnyayog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Usercontroller {

	@Autowired
	UserService userService;

	@PostMapping(path = "/save", produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml" })
	public UserResponse saveUser(@RequestBody UserRequest user) {
		return userService.addUser(user);
	}

	@GetMapping(path = "/getByName/{firstName}", produces = { "application/json", "application/xml" })
	public UserResponse getUserByFirstName(@PathVariable String firstName) throws SQLException {
		UserRequest request = new UserRequest();
		request.setUsername(firstName);
		return userService.getUserByFirstName(request);
	}

	@GetMapping(path = "/getUsers", produces = { "application/json", "application/xml" })
	public UserResponse displayUsers() throws SQLException {
		return userService.displayUser();
	}
}
