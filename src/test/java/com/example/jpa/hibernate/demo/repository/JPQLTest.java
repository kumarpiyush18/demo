package com.example.jpa.hibernate.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpa.hibernate.demo.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@RunWith(SpringRunner.class)
@SpringBootTest
class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	@Test
	void contextLoads() {
		List  resultList = em.createQuery("Select c From Course c").getResultList();
		logger.info("List result -> {}", resultList);
//		List result -> [Course [Microservice in 100 steps], Course [JPA IN 50 STEPS], Course [DEVOPS IN 50 STEPS], Course [JAVA IN 50 STEPS], Course [SPING IN 50 STEPS]]
		
	}
	
	@Test
	void findById_typed() {
		TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
		List <Course> resultList = query.getResultList();
		logger.info("List result -> {}", resultList);
//		List result -> [Course [Microservice in 100 steps], Course [JPA IN 50 STEPS], Course [DEVOPS IN 50 STEPS], Course [JAVA IN 50 STEPS], Course [SPING IN 50 STEPS]]
		
	}
	

}
	