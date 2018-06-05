package com.vishal.interviews.google.careercup;

import java.util.*;

/**
 * write a function to generate a random 4 digit unique even number, the four
 * digits cannot be the same, 1234 is valid, but 1134 is not valid
 *
 * 
 */
public class RandomFourDigigNumber {

	public static void main(String[] args) {

		System.out.println(rand4DigitNumber());
	}

	static int rand4DigitNumber() {
		boolean[] used = new boolean[10];

		Random rand = new Random();
		int res = 0;

		for (int i = 0; i < 4; i++) {
			int val = rand.nextInt(10);
			while ((i == 0 && val == 0) || used[val]) {
				val = rand.nextInt(10);
			}
			res = res * 10 + val;
			used[val] = true;
		}
		return res;
	}

}
