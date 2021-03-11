package com.luv2code.aopdemo.dao;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	@Before("execution(public void addAccount())")
	public String addMember() {
		System.out.println(getClass().getSimpleName() + ": Doing Stuff: Adding a membership account");
		return null;
	}
}
