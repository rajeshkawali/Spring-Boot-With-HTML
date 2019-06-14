package com.travels.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.travels.model.Student;


@Repository
public class StudentDaoImplements implements StudentDao {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		String hql = "FROM Student as std ORDER BY std.id";
		return (List<Student>) entityManager.createQuery(hql).getResultList();
	}
	@Override
	public Student getStudentById(int id) {
		return entityManager.find(Student.class, id);
	}
	public void addStudent(Student student) {
		 entityManager.persist(student);
	}
	@Override
	public void updateStudent(Student student) {
		Student std = getStudentById(student.getId());
		std.setFirstname(student.getFirstname());
		std.setLastname(student.getLastname());
		std.setPercentage(student.getPercentage());
		entityManager.flush();
	}
	@Override
	public void deleteStudent(int id) {
		entityManager.remove(getStudentById(id));
	}
	@Override
	public boolean studentExists(String fname, String lname,double percent) {
		String hql = "FROM Student as std WHERE std.firstname = ? and std.lastname = ? and std.percentage = ?";
		int count = entityManager.createQuery(hql).setParameter(1, fname).setParameter(2, lname).setParameter(3, percent).getResultList().size();
		return count > 0 ? true : false;
	}
}
