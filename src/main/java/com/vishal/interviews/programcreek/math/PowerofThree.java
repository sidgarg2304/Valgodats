package com.vishal.interviews.programcreek.math;

public class PowerofThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPowerOfThree(int n) {
		if (n > 1) {
			while (n % 3 == 0) {
				n /= 3;
			}
		}

		return n == 1;
	}
}
