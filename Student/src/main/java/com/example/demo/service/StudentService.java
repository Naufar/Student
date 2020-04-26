package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Audit;
import com.example.demo.entity.Student;

@Service
public interface StudentService {
	
	public List<Student> findStudent(Audit audit);

	public List<Student> getAllStudents();

	public int updateStudents(Audit audit);

}
