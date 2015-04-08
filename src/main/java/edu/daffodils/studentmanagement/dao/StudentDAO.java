package edu.daffodils.studentmanagement.dao;

import java.util.List;

import edu.daffodils.studentmanagement.model.Student;

public interface StudentDAO {
	public long save(Student student);

	public Student getById(String regID);

	public long update(Student student);

	public long deleteById(int id);

	public List<Student> getAll();
}
