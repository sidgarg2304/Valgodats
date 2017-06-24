package com.vishal.interviews.linkedin.careercup;

/**
 * Implement the integral part logn base 2 with bit manipulations
 *
 */
public class LogBase2 {

	public static void main(String[] args) {

	}

	int integralPartOfLog(int n) {
		int cnt = 0;
		while (n > 0) {
			n >>= 1;
			cnt++;
		}

		return cnt - 1;
	}

}
