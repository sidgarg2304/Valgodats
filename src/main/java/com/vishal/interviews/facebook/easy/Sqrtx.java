package com.vishal.interviews.facebook.easy;

/**
 * 69. Sqrt(x)
 * 
 * Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
 *
 */
public class Sqrtx {

	public static void main(String[] args) {

	}

	public int mySqrt(int x) {
      if (x == 0) {
			return 0;
		}

		int l = 1;
		int r = x / 2;

		while (l <= r) {
			int m = l + (r - l) / 2;

			if (m > x / m) {
				r = m - 1;
			} else {

				if ((m + 1) > x / (m + 1)) {
					return m;
				}

				l = m + 1;
			}
		}
		return l;
  }
}
