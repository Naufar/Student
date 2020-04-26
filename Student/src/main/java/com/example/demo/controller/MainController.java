package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Audit;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.naufar.demo.util.ApiResponse;

@RestController
public class MainController {

	@Autowired
	StudentService studentService;
	
	private static String message = "Success";

	@PostMapping("/selectStudents")
	public ResponseEntity<?> findStudent(@RequestBody Audit audit) {

		List<Student> student = studentService.findStudent(audit);
		
		if (null == student)
			message = "Please check the query.Delete or Truncate query is not acceptable";
		
		return new ResponseEntity<>(new ApiResponse("Success", message, student), HttpStatus.OK);
	}

	@PostMapping("/updateStudents")
	public ResponseEntity<?> updateStudents(@RequestBody Audit audit) {

		int count = studentService.updateStudents(audit);
		
		if (count <= 0)
			message = "Please check the query.Delete or Truncate query is not acceptable.Query must have a where condition";
		
		return new ResponseEntity<>(new ApiResponse("Success", message, count), HttpStatus.OK);
	}

	@GetMapping("/getAllStudents")
	public ResponseEntity<?> getAllStudents() {

		List<Student> student = studentService.getAllStudents();

		return new ResponseEntity<>(new ApiResponse("Success", message,student), HttpStatus.OK);
	}

}
