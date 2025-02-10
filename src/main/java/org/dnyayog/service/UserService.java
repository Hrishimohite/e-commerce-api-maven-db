package org.dnyayog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.dnyayog.common.DBUtils;
import org.dnyayog.dto.User;
import org.dnyayog.dto.UserRequest;
import org.dnyayog.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UserService {
	@Autowired
	UserResponse responce;
	@Autowired
	User users;

	// save user
	public UserResponse addUser(UserRequest request) {

		String query = "INSERT INTO user(number,username, email,userPassword)" + " VALUES ('" + request.getNumber()
				+ "','" + request.getUsername() + "','" + request.getEmail() + "','" + request.getUserPassword()
				+ "');";

		try {
			Statement statement = DBUtils.connection.createStatement();
			statement.execute(query);
			users.setUsername(request.getUsername());
			users.setEmail(request.getEmail());
			users.setNumber(request.getNumber());
			responce.setResponceCode("0000");
			responce.setResponceMessage("user added successfully.");

		} catch (SQLException e) {
			e.printStackTrace();
			responce.setResponceCode("911");
			responce.setResponceMessage("User add failed !");
		}
		return responce;

	}

//search user
	public UserResponse getUserByFirstName(UserRequest request) throws SQLException {
		List<UserResponse> userList = new ArrayList<>();

		ResultSet rs = DBUtils
				.executeSelectQuery("SELECT * FROM user WHERE username = '" + request.getUsername() + "';");

		try {
			while (rs.next()) {
				users.setNumber(rs.getString(1));
				users.setEmail(rs.getString(2));
				users.setUsername(rs.getString(3));

				userList.add(responce);
				responce.setResponceCode("0000");
				responce.setResponceMessage("user found");
			}

		} catch (Exception e) {
			responce.setResponceCode("911");
			responce.setResponceMessage("User not found...");

			e.printStackTrace();
		}
		return responce;

	}

//display user
	public UserResponse displayUser() throws SQLException {
		ArrayList<User> users = new ArrayList<>();

		try {
			ResultSet rs = DBUtils.executeSelectQuery("SELECT * FROM user");

			while (rs.next()) {
				User user = new User();
				user.setNumber(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setUsername(rs.getString(3));
				users.add(user);

				responce.setUsers(users);
				responce.setResponceCode("000");
				responce.setResponceMessage("Users displayed");
			}
		} catch (Exception e) {
			
			responce.setResponceCode("911");
			responce.setResponceMessage("User not found !!");
		
			e.printStackTrace();

		}

		return responce;
	}
}
