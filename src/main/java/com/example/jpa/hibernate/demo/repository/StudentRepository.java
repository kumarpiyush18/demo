package com.example.jpa.hibernate.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpa.hibernate.demo.entity.Passport;
import com.example.jpa.hibernate.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	private EntityManager em;
	
	// find by id
	public Student findById(Long id) {
		return em.find(Student.class,id);
	}
	
	
	// save Student
	public Student 	save(Student student) {
		if(student.getId()==null) {
			em.persist(student);
		}
		else {
			em.merge(student);
		}
		
		return student;
	}
	
	
	//deleteById
	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z793958");
		em.persist(passport);
		Student student = new Student("Mike");
		student.setPassport(passport);
		em.persist(student);
	}
}
