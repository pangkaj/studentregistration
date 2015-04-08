package edu.daffodils.studentmanagement.service;

import java.util.Date;
import java.util.List;

import edu.daffodils.studentmanagement.model.Student;

public interface StudentManager {
	List<Student> readAllStudents();

    long createStudent(String firstName, String lastName, Date birthdate);

    Student readStudent(String regID);

    long deleteStudent(String regID);
}
