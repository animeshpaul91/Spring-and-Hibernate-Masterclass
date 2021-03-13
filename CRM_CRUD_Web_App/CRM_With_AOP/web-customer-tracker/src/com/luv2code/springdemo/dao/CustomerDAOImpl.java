package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.util.SortUtils;

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

		// save or update the customer depending if the id exists or not
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// retrieve from database using primary key
		Customer customer = session.get(Customer.class, id);

		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// delete the object with the primary key ID
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String name) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		Query query = null;

		if (name != null && name.trim().length() > 0) {
			query = session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name",
					Customer.class);
			query.setParameter("name", "%" + name.toLowerCase() + "%");
		} else {
			query = session.createQuery("from Customer", Customer.class);
		}

		List<Customer> customers = query.getResultList();

		return customers;
	}

	@Override
	public List<Customer> getCustomers(int sortField) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String fieldName = null;

		switch (sortField) {
		case SortUtils.FIRST_NAME:
			fieldName = "firstName";
			break;

		case SortUtils.LAST_NAME:
			fieldName = "lastName";
			break;

		case SortUtils.EMAIL:
			fieldName = "email";
			break;

		default:
			fieldName = "lastName";
		}
		
		String queryString = "from Customer order by " + fieldName;
		Query<Customer> query = session.createQuery(queryString, Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

}
