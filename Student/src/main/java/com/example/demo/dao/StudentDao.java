package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentDao {

	List<Student> findStudent(String query);

	List<Student> getAllStudents();

	int updateStudents(String query);

}
