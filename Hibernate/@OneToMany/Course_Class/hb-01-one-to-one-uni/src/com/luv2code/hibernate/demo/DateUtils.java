package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public static Date parseDate(String dateStr) throws ParseException {
		Date date = formatter.parse(dateStr);
		return date;
	}

	public static String formatDate(Date date) { // not being used in project
		return date != null ? formatter.format(date) : null;
	}
}
