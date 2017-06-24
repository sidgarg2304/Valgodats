package com.vishal.interviews.facebook.careercup;

/**
 * Enter a two digit number, find the year closest to this year. Example input
 * 99, return 1999; Input 15, return 2015.
 *
 */
public class ClosestYear {

	public static void main(String[] args) {
		System.out.println(getClosestYear(15, 1917));
		System.out.println(getClosestYear(99, 2017));
	}

	public static int getClosestYear(int input, int curYear) {

		int century = curYear / 100;
		int left = (century - 1) * 100 + input;
		int right = (century) * 100 + input;

		if (curYear - left < right - curYear) {
			return left;
		}

		return right;
	}

}
