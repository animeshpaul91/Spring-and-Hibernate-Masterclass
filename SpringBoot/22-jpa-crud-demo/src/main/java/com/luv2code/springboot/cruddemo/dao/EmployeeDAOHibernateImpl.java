package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// entity manager bean is constructed by spring boot
	// set up constructor injection. Could have done a field injection as well.
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// using native Hibernate API
		// get the hibernate session
		Session session = entityManager.unwrap(Session.class);
		// create a query
		Query<Employee> query = session.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> employees = query.getResultList();

		// return results
		return employees;
	}

	@Override
	public Employee findById(int id) {
		// get the current hibernate sesssion
		Session session = entityManager.unwrap(Session.class);
		
		// get the employee
		Employee employee = session.get(Employee.class, id);
		
		// return the employee 
		return employee;
	}

	@Override
	public void save(Employee employee) {
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// save employee
		session.saveOrUpdate(employee); // if id is 0 create else update existing employee
		
	}

	@Override
	public void delete(int id) {
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query query = session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}
	
}
