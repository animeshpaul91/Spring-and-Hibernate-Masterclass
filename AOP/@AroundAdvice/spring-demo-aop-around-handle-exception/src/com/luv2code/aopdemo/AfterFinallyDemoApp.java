package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = null;

		try {
			// add a boolean flag to simulate exception
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		}

		catch (Exception exception) {
			System.out.println("\n\nMain Program: Caught Exception: " + exception);
		}

		// display the accounts
		System.out.println("\n\nMain Program: After Throwing Demo App");
		System.out.println("-------------------------------------------");
		System.out.println(accounts);
		System.out.println("\n");

		// close the context
		context.close();

	}

}
