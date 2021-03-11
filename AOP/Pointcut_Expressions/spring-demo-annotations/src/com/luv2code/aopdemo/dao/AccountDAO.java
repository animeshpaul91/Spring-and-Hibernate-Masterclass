package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass().getSimpleName() + ": Doing my db work: Adding an Account");
	}
	
	public boolean doWork() {
		System.out.println(getClass().getSimpleName() + ": doWork()");
		return false;
	}
}
