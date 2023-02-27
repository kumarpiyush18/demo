package com.example.jpa.hibernate.demo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Todo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String todo;
	
	protected Todo() {
		
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public Long getId() {
		return id;
	}
	
	

}
