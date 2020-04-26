package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Student> findStudent(String query) {
		Query query2 = entityManager.createNativeQuery(query, Student.class);
		List<Student> student = query2.getResultList();
		return student;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		Query query2 = entityManager.createNativeQuery("Select * from student_info s", Student.class);
		List<Student> student = query2.getResultList();
		return student;
	}

	@Override
	@Modifying
	public int updateStudents(String query) {
		int count = entityManager.createNativeQuery(query, Student.class).executeUpdate();
		return count;
	}

}
