package com.travels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travels.dao.StudentDao;
import com.travels.model.Student;


@Service
@Transactional
public class StudentServiceImplements implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public Student getStudentById(int id) {
		Student std = studentDao.getStudentById(id);
		return std;
	}
	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}
	
	@Override
	public synchronized boolean addStudent(Student student) {
		if (studentDao.studentExists(student.getFirstname(), student.getLastname(),student.getPercentage())) {
			return false;
		} else {
			studentDao.addStudent(student);
			return true;
		}
	}
	
	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
		
	}
	@Override
	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);
		
	}
}
