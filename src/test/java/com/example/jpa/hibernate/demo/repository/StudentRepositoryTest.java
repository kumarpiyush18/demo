package com.example.jpa.hibernate.demo.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpa.hibernate.demo.entity.Passport;
import com.example.jpa.hibernate.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudentRepository repository;
	
	@Autowired 
	EntityManager em;
	
	@Test
	@Transactional
	void retrieveStudentAndPassportDetails() {
		
		Student student = em.find(Student.class,20001L); 
		logger.info("Student -> {}", student);
		logger.info("Passport -> {}", student.getPassport());
		
	}
	
	@Test
	@Transactional
	void retrievePassportAndAssocitatedStudent() {
		
		Passport passport = em.find(Passport.class,40001L); 
		logger.info("Passport -> {}", passport);
		logger.info("Student -> {}", passport.getStudent());
		
	}
	
	

}
	