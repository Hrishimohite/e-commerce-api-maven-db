package org.dnyayog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyayog.common.DBUtils;

public class StudentService {

	public String getFirstName(String username) {
		try {
			ResultSet rs = DBUtils.executeSelectQuery("select * from user where username='" + username + "'");
			rs.next();
			return rs.getString(2);
		} catch (SQLException e) {
			return "some error occured";
		}
	}

	public String getEmail(String username) {
		try {
			ResultSet rs = DBUtils.executeSelectQuery("select * from user where username='" + username + "'");
			rs.next();
			return rs.getString(3);
		} catch (SQLException e) {
			return "some error occured";
		}
	}
	public List<String> getStudentData() throws SQLException{
		ArrayList<String> user=new ArrayList<>();
		ResultSet rs = DBUtils.executeSelectQuery("select * from user ");
		
		while (rs.next()) { 
	        user.add(rs.getString("username"));  
	       
	    }
		return user;	
	}


}
