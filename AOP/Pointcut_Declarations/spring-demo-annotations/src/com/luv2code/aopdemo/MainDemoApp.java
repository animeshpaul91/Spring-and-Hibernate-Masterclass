package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		Account account = new Account();
		accountDAO.addAccount(account, true);
		accountDAO.doWork();

		// call the accountDAO getters and setters
		
		System.out.println("\nGetters and Setters Beginning...");
		accountDAO.setName("FooBar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		System.out.println("Getters and Setters Ending...");

		// call the membership method
		membershipDAO.addMember();
		membershipDAO.goToSleep();

		// close the context
		context.close();

	}

}
