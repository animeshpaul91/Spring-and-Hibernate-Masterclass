package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/spring?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		String user = "animesh";
		String password = "Babubabu123**";

		try {
			System.out.println("Connecting to databse: " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection Successful");
		} catch (Exception exception) {
			System.out.println("Something is Wrong");
			exception.printStackTrace();
		}
	}

}
