package com.travels.dao;

import java.util.List;

import com.travels.model.Student;

public interface StudentDao {

	List<Student> getAllStudents();
	Student getStudentById(int id);
	public void addStudent(Student student);
	boolean studentExists(String fname, String lname,double percent);
	void updateStudent(Student student);
	void deleteStudent(int id);

}
