package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.internal.build.AllowSysOut;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
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
