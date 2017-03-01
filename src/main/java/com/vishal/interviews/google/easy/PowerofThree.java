package com.vishal.interviews.google.easy;

/**
 * 326. Power of Three
 * 
 * Given an integer, write a function to determine if it is a power of three.
 * 
 * Follow up: Could you do it without using any loop / recursion?
 * 
 */
public class PowerofThree {

	public static void main(String[] args) {
	}

	/**
	 * 1 line java solution without loop / recursion
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThreeOneLine(int n) {
		// 1162261467 is 3^19, 3^20 is bigger than int
		return (n > 0 && 1162261467 % n == 0);
	}

	/**
	 * Well, this problem doesn't seem to be quite interesting or worthwhile to
	 * think about at a first glance. I had the same feeling at the beginning.
	 * However, after seeing a couple of posts, I saw a couple of interesting
	 * ways. So here is a summary post and hope you learn something from others'
	 * solutions.
	 * 
	 * Two trivial solutions first: #Recursive Solution#
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThreeRecursive(int n) {
		return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThreeRecursive(n / 3)));
	}

	public boolean isPowerOfThreeIterative(int n) {
		if (n > 1)
			while (n % 3 == 0)
				n /= 3;
		return n == 1;
	}

	/**
	 * Find the maximum integer that is a power of 3 and check if it is a
	 * multiple of the given input.
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThreeUsingMultiple(int n) {
		int maxPowerOfThree = (int) Math.pow(3, (int) (Math.log(0x7fffffff) / Math.log(3)));
		return n > 0 && maxPowerOfThree % n == 0;
	}

	/**
	 * Or simply hard code it since we know maxPowerOfThree = 1162261467:
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThreeUsingMultipleHardCodedValue(int n) {
		return n > 0 && (1162261467 % n == 0);
	}
}
