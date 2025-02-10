package org.dnyayog.controller;

import java.sql.SQLException;
import java.util.List;

import org.dnyayog.dto.Student;
import org.dnyayog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Studentcontroller {
	@GetMapping("/firstName/{student}")
	public String getFirstName(@PathVariable String student) {
		return new StudentService().getFirstName(student);
	}

	@GetMapping("/email/{email}")
	public String getEmail(@PathVariable String email) {
		return new StudentService().getEmail(email);
	}

	@GetMapping("/rollnumber")
	public List<String> getStudentData() throws SQLException {

		return new StudentService().getStudentData();
	}

	@Autowired
	Student std;

	@GetMapping("/student/info")
	public Student getStudent() {
		std.firstName = "hrishikesh";
		std.lastName = "mohite";
		std.mobile = "8412003145";
		std.age = 22;
		return std;
	}
 @PostMapping(path="/student/info", produces={"application/json"} ,consumes={"application/json"})
  public String saveStudentData(@RequestBody  Student student) {
	System.out.println(student.firstName);
	System.out.println(student.lastName);
	System.out.println(student.mobile);
	System.out.println(student.age);
	return "data saved";
 }
}
