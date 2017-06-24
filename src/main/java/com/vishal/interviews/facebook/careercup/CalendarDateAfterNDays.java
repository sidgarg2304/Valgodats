package com.vishal.interviews.facebook.careercup;

/**
 * Given a Calendar class (there are three fields, year, month, day) and a
 * number of N, Implement a function that returns the calendar after N days, For
 * example, if the input is {2017, 3,20} and 12, then the return is {2017,4, 1}
 *
 */
public class CalendarDateAfterNDays {

	public static void main(String[] args) {

		System.out.println(dateAfterNDays(new Calendar(2017, 3, 20), 12));
	}

	static int[] months = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	static Calendar dateAfterNDays(Calendar c, int n) {

		int year = c.year;
		int month = c.month;
		int day = c.day;

		int noOfRemaining = n;
		while (noOfRemaining > 0) {
			int daysInCurrMonth = months[month];

			if (month == 2 && isLeapYear(year)) {
				daysInCurrMonth += 1;
			}

			int curMonthRemaningDays = daysInCurrMonth - day;

			if (noOfRemaining > curMonthRemaningDays) {
				noOfRemaining -= curMonthRemaningDays;
				month += 1;
				day = 0;
				if (month == 13) {
					month = 1;
					year += 1;
				}
			} else {
				day += noOfRemaining;
				noOfRemaining = 0;
			}
		}

		return new Calendar(year, month, day);
	}

	static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}
}

class Calendar {
	public int year;
	public int month;
	public int day;

	public Calendar(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String toString() {
		return "" + month + "-" + day + "-" + year;
	}
}
