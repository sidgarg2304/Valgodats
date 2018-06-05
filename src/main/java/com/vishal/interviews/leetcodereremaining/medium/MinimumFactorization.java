package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;
/**
 * 625. Minimum Factorization
 * 
 * Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.

If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.

Example 1
Input:

48 
Output:
68
Example 2
Input:

15
Output:
35
 *
 */
public class MinimumFactorization {

	public static void main(String[] args) {

	}

	public int smallestFactorization(int a) {
		if (a < 10) {
			return a;
		}

		List<Integer> factors = new ArrayList<>();
		for (int i = 9; i > 1; i--) {
			while (a % i == 0) {
				a /= i;
				factors.add(i);
			}
		}

		// for prime numbers
		if (a != 1) {
			return 0;
		}

		long res = 0;
		for (int i = factors.size() - 1; i >= 0; i--) {
			res = res * 10 + factors.get(i);
			if (res > Integer.MAX_VALUE) {
				return 0;
			}
		}
		
		return (int) res;
	}
}
