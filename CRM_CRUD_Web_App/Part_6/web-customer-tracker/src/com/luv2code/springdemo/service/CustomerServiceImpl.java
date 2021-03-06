package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers = customerDAO.getCustomers();
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(id);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String name) {
		// TODO Auto-generated method stub
		return customerDAO.searchCustomers(name);
	}

	@Override
	@Transactional
	public List<Customer> getCustomers(int sortField) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers(sortField);
	}
	
}
