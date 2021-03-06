package com.vishal.interviews.google.easy;

/**
 * 
 * 400
 * 
 * 
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8,
 * 9, 10, 11, ...
 * 
 * Note: n is positive and will fit within the range of a 32-bit signed integer
 * (n < 231).
 * 
 * Example 1:
 * 
 * Input: 3
 * 
 * Output: 3 Example 2:
 * 
 * Input: 11
 * 
 * Output: 0
 * 
 * Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
 * 11, ... is a 0, which is part of the number 10.
 * 
 * @author vkotha
 *
 */
public class NthDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Straight forward way to solve the problem in 3 steps:
	 * 
	 * find the length of the number where the nth digit is from find the actual
	 * number where the nth digit is from find the nth digit and return
	 * 
	 * @param n
	 * @return
	 */
	public int findNthDigit(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}

	/**
	 * Check the same-length ranges 1-9, 10-99, 100-999, 1000-9999, etc.
	 * 
	 * @param n
	 * @return
	 */
	public int findNthDigitShort(int n) {
		n -= 1;
		int digits = 1, first = 1;
		while (n / 9 / first / digits >= 1) {
			n -= 9 * first * digits;
			digits++;
			first *= 10;
		}
		return (first + n / digits + "").charAt(n % digits) - '0';
	}

}
