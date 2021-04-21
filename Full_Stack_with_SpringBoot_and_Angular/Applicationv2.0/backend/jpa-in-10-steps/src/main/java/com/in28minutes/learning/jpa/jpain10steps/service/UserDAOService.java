package com.in28minutes.learning.jpa.jpain10steps.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;

@Repository // which interacts with database
@Transactional // each method will be involved in a transaction
public class UserDAOService {
	
	@PersistenceContext
	private EntityManager entityManager; // is a handle to all objects persisted
	
	public long insert(User user) {
		entityManager.persist(user); // user will be a part of persistence context and will be tracked by the entityManager hereon
		return user.getId();
	}
}
