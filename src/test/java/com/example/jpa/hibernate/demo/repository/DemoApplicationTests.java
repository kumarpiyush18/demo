package com.example.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository repository;
	@Test
	void contextLoads() {
		Course  course = repository.findById(10001L);
		assertEquals("JPA IN 50 STEPS",course.getName());
		
	}
	
	
	//because it is modifying the state of the data base we need to do annotation @DirtiesContext after the test is run 
	// spring would place the data so for other test the data is not changed at all
	@DirtiesContext
	@Test
	void deleteById() {
		repository.deleteById(10001L);
		assertNull(repository.findById(10001L));
		
	}
	
	@DirtiesContext
	@Test
	void save() {
		Course  course = repository.findById(10001L);
		assertEquals("JPA IN 50 STEPS",course.getName());
		//update the detail fo the course
		course.setName("JPA IN 50 STEPS - UPDATED");
		
		repository.save(course);
		Course  course1 = repository.findById(10001L);
		assertEquals("JPA IN 50 STEPS - UPDATED",course1.getName());
		
		
		
	}
	

}
	