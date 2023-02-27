package com.example.jpa.hibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.hibernate.demo.entity.Course;
import com.example.jpa.hibernate.demo.repository.CourseRepository;
import com.example.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired 
	private StudentRepository studentRepository;
	@Autowired 
	private CourseRepository courseRepository;
	public static void main(String[] args)  {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		studentRepository.saveStudentWithPassport();
		courseRepository.addReviewsForCourse();
//		Course course = repository.findById(10001L);
//		logger.info("Couser details -> {}", course);
//		repository.save(new Course("Microservice in 100 steps"));
		
		
	}

}
