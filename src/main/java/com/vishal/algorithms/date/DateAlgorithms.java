package com.vishal.algorithms.date;

import java.util.Date;
import java.util.TimerTask;

public class DateAlgorithms {

	public static void main(String[] args) {

		addDaysUsingDateApi(new Date(System.currentTimeMillis()), 10);

	}

	static void addDaysUsingDateApi(Date date, int days) {

		long timeInMillis = date.getTime();

		long newTimeInMillis = timeInMillis + days * 24 * 60 * 60 * 1000;

		System.out.println("Date after " + days + " days is " + new Date(newTimeInMillis).toString());

	}

	static void addDays(Date date, int days) {

		long timeInMillis = date.getTime();

		long newTimeInMillis = timeInMillis + days * 24 * 60 * 60 * 1000;

		System.out.println("Date after " + days + " days is " + new Date(newTimeInMillis).toString());

	}

}
