package com.vishal.interviews.linkedin.medium;

/**
 * 50. Pow(x, n)
 * 
 * Implement pow(x, n).
 */
public class Powxn {

	public static void main(String[] args) {

	}

	public double powShortAndEasy(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return (n % 2 == 0) ? powShortAndEasy(x * x, n / 2) : x * powShortAndEasy(x * x, n / 2);
	}

	/**
	 * Iterative Log(N) solution with Clear Explanation I couldn't find a clear
	 * explanation for an interative Log(n) solution so here's mine. The basic
	 * idea is to decompose the exponent into powers of 2, so that you can keep
	 * dividing the problem in half. For example, lets say
	 * 
	 * N = 9 = 2^3 + 2^0 = 1001 in binary. Then:
	 * 
	 * x^9 = x^(2^3) * x^(2^0)
	 * 
	 * We can see that every time we encounter a 1 in the binary representation
	 * of N, we need to multiply the answer with x^(2^i) where i is the ith bit
	 * of the exponent. Thus, we can keep a running total of repeatedly squaring
	 * x - (x, x^2, x^4, x^8, etc) and multiply it by the answer when we see a 1.
	 * 
	 * To handle the case where N=INTEGER_MIN we use a long (64-bit) variable.
	 * Below is solution:
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double MyPowIterativeGood(double x, int n) {
		double ans = 1;
		long absN = Math.abs((long) n);
		while (absN > 0) {
			if ((absN & 1) == 1)
				ans *= x;
			absN >>= 1;
			x *= x;
		}
		return n < 0 ? 1 / ans : ans;
	}

	/**
	 * O (logn) solution in Java This is a simple solution based on divide and
	 * conquer
	 * 
	 * @param x
	 * @param m
	 * @return
	 */
	public double powDivideAndConquer(double x, int m) {
		double temp = x;
		if (m == 0)
			return 1;
		temp = powDivideAndConquer(x, m / 2);
		if (m % 2 == 0)
			return temp * temp;
		else {
			if (m > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}

	/**
	 * nest myPow
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	double myPowNest(double x, int n) {
		if (n < 0)
			return 1 / x * myPowNest(1 / x, -(n + 1));
		if (n == 0)
			return 1;
		if (n == 2)
			return x * x;
		if (n % 2 == 0)
			return myPowNest(myPowNest(x, n / 2), 2);
		else
			return x * myPowNest(myPowNest(x, n / 2), 2);
	}

	/**
	 * double myPow
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	double myPowDouble(double x, int n) {
		if (n == 0)
			return 1;
		double t = myPowDouble(x, n / 2);
		if (n % 2 == 1)
			return n < 0 ? 1 / x * t * t : x * t * t;
		else
			return t * t;
	}

	/**
	 * double x
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	double myPowDoubleX(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return n % 2 == 0 ? myPowDoubleX(x * x, n / 2) : x * myPowDoubleX(x * x, n / 2);
	}

	double myPowIterative(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		double ans = 1;
		while (n > 0) {
			if ((n & 1) != 0)
				ans *= x;
			x *= x;
			n >>= 1;
		}
		return ans;
	}

	/**
	 * https://discuss.leetcode.com/topic/3636/my-answer-using-bit-operation-c-
	 * implementation
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	double powUsingBit(double x, int n) {
		if (n < 0) {
			x = 1.0 / x;
			n = -n;
		}
		int m = n;
		double tbl[] = new double[32];
		double result = 1;
		tbl[0] = x;
		for (int i = 1; i < 32; i++) {
			tbl[i] = tbl[i - 1] * tbl[i - 1];
		}
		for (int i = 0; i < 32; i++) {
			if ((m & (0x1 << i)) != 0)
				result *= tbl[i];
		}
		return result;
	}

}
