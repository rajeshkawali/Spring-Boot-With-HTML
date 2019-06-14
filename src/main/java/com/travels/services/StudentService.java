package com.travels.services;

import java.util.List;

import com.travels.model.Student;


public interface StudentService {

	List<Student> getAllStudents();
	Student getStudentById(int id);
	boolean addStudent(Student student);
	void updateStudent(Student student);
    void deleteStudent(int id);

}
