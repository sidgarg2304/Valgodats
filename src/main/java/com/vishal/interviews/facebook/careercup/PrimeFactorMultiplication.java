package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * prime factors. given a number return the prime factor multiplication. eg. 90
 * = 2 * 3 * 3 * 5.
 *
 */
public class PrimeFactorMultiplication {

	public static void main(String[] args) {

		System.out.println(primeFactors(77));
	}

	static List<Integer> primeFactors(int n) {
		List<Integer> res = new ArrayList<>();

		// to take care of even number
		while (n % 2 == 0) {
			res.add(2);
			n /= 2;
		}

		// as of now, the number is odd
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				res.add(i);
				n /= i;
			}
		}

		if (n > 2) {
			res.add(n);
		}
		return res;
	}

}
