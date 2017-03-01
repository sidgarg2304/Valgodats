package com.vishal.interviews.google.easy;

/**
 * 
 * 231. Power of Two
 * 
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * 
 */
public class PowerofTwo {

	public static void main(String[] args) {

	}

	public boolean isPowerOfTwo(int n) {
		return ((n & (n - 1)) == 0 && n > 0);
	}

	/**
	 * This is kind of cheating, but the idea is that a power of two in binary
	 * form has and only has one "1".
	 * 
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPowerOfTwoUsingBitCount(int n) {
		return n > 0 && Integer.bitCount(n) == 1;
	}

}
