package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.rest.webservices.restfulwebservices.entity.Todo;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long> {
	public List<Todo> findByUsername(String username);
}
