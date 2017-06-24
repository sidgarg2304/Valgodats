package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * Find out if the given string forms a valid lottery number.
 * 
 * - A valid lottery number contains 7 unique digits between 1 and 59.
 * 
 * e.g.
 * 
 * 4938532894754 (yes) -> 49 38 53 28 9 47 54
 * 
 * 1634616512 (yes) -> 1 6 34 6 16 51 2
 * 
 * 1122334 (no)
 *
 * 
 */
public class ValidLotteryNumber {

	public static void main(String[] args) {

		System.out.println(validLotteryNumber("1122334", new ArrayList<>()));
	}

	static boolean validLotteryNumber(String s, List<Integer> lotteryNumbers) {
		if (s.length() == 0 && lotteryNumbers.size() == 7) {
			return true;
		}

		if (lotteryNumbers.size() > 7 || s.length() == 0) {
			return false;
		}

		for (int i = 1; i <= Math.min(2, s.length()); i++) {
			int val = Integer.parseInt(s.substring(0, i));

			if (val >= 1 && val <= 59 && !lotteryNumbers.contains(val)) {
				lotteryNumbers.add(val);
				if (validLotteryNumber(s.substring(i), lotteryNumbers)) {
					lotteryNumbers.remove(lotteryNumbers.size() - 1);
					return true;
				}
				lotteryNumbers.remove(lotteryNumbers.size() - 1);
			}
		}
		return false;
	}
}
