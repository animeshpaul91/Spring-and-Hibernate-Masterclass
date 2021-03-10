package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory so that DAO can use it to talk to backend

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// create a query sorted by last name
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result list
		List<Customer> customers = query.getResultList();

		// return results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// get the hibernate session
		Session session = sessionFactory.getCurrentSession();

		// save the customer
		session.save(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// retrieve from database using primary key
		Customer customer = session.get(Customer.class, id);

		return customer;
	}
}
