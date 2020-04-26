package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AuditDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Audit;
import com.example.demo.entity.Student;
import com.naufar.demo.util.CustomException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	AuditDao auditDao;

	@Autowired
	StudentDao studentDao;

	@Override
	public List<Student> getAllStudents() {
		List<Student> stud = studentDao.getAllStudents();
		return stud;
	}

	@Override
	public List<Student> findStudent(Audit audit) {

		List<Student> stud = null;
		if (null != audit) {
			try {
				if (null != audit.getQuery() && !audit.getQuery().isEmpty()) {

					auditDao.save(audit);
					String query = audit.getQuery();

					if (query.contains("delete") || query.contains("truncate"))
						throw new CustomException("Delete or Truncate query is not acceptable");
					else
						stud = studentDao.findStudent(query);

				}
			}

			catch (CustomException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return stud;
	}

	@Override
	public int updateStudents(Audit audit) {
		int count = 0;
		if (null != audit) {
			try {
				if (null != audit.getQuery() && !audit.getQuery().isEmpty()) {

					auditDao.save(audit);
					String query = audit.getQuery();

					if (query.contains("delete") || query.contains("truncate"))
						throw new CustomException("Delete or Truncate query is not acceptable");
					else {
						if (query.contains("where"))
							count = studentDao.updateStudents(query);
						else
							throw new CustomException("Update Query must contain a where condition");
					}
				}

			} catch (CustomException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return count;
	}

}
