package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass().getSimpleName() + ": Doing my db work: Adding an Account");
	}
}
