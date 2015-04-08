package edu.daffodils.studentmanagement.service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.daffodils.studentmanagement.dao.StudentDAO;
import edu.daffodils.studentmanagement.model.Student;

@Service
public final class StudentServiceImpl implements StudentManager {
	
	private StudentDAO studentDAO;
	private Logger logger = Logger.getLogger(StudentServiceImpl.class.getName());
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Student> readAllStudents() {
		logger.info("Query all student list");
		return studentDAO.getAll();
	}

	@Override
	@Transactional
	public long createStudent(String firstName, String lastName, Date birthDate) {
		long regID = new Random(100000).nextLong();
		Student student = new Student(regID, firstName, lastName, birthDate);
		return studentDAO.save(student);
	}

	@Override
	@Transactional(readOnly = true)
	public Student readStudent(String regID) {
		return studentDAO.getById(regID);
	}

	@Override
	@Transactional
	public long deleteStudent(String regID) {
		return 0;
	}

}
