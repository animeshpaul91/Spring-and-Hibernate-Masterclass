package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	// add a new method: findAccounts
	public List<Account> findAccounts() {
		List<Account> accounts  = new ArrayList<>();
		
		// create sample Accounts
		Account account1 = new Account("Animesh", "Platinum");
		Account account2 = new Account("Madhu", "Silver");
		Account account3 = new Account("Luca", "Gold");
		
		// add accounts to List
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		
		return accounts;
	}

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass().getSimpleName() + ": Doing my db work: Adding an Account");
	}

	public boolean doWork() {
		System.out.println(getClass().getSimpleName() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass().getSimpleName() + ": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass().getSimpleName() + ": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass().getSimpleName() + ": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass().getSimpleName() + ": setServiceCode()");
		this.serviceCode = serviceCode;
	}
}
