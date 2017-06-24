package com.vishal.interviews.linkedin.careercup;

/**
 * Given a number n that represents n lockers and n students. All lockers start
 * closed. First student goes and opens all the lockers. Second goes and toggles
 * 2nd, 4th, 6th.. lockers. Third student toggles 3rd, 6th, 9th.. lockers. Print
 * the lockers that remain open after all students pass.
 */
public class LockersRemainOpen {

	public static void main(String[] args) {

		lockers(10);
	}

	public static void lockers(int n) {

		for (int i = 1; i <= Math.sqrt(n); i++) {
			System.out.println("locker open is " + (i* i ));
		}
	}

}
