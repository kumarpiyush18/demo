package com.example.jpa.hibernate.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpa.hibernate.demo.entity.Course;
import com.example.jpa.hibernate.demo.entity.Review;

import ch.qos.logback.classic.Logger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	private EntityManager em;
	
	// find by id
	public Course findById(Long id) {
		return em.find(Course.class,id);
	}
	
	
	// save course
	public Course 	save(Course course) {
		if(course.getId()==null) {
			em.persist(course);
		}
		else {
			em.merge(course);
		}
		
		return course;
	}
	
	
	//deleteById
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}


	public void addReviewsForCourse() {
		// TODO Auto-generated method stub
		Course course = findById(10003L);
		
		Review review = new Review("5", "Great hands on stuff");
		Review review2 = new Review("4", "loving it");
		
		course.addReview(review);
		review.setCourse(course);
		course.addReview(review2);
		review2.setCourse(course);
		em.persist(review2);
		em.persist(review);
	}
}
