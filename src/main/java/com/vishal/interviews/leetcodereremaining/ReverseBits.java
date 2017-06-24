package com.vishal.interviews.leetcodereremaining;

public class ReverseBits {

	public static void main(String[] args) {

	}

	public static int reverseBits(int n) {

		if (n == 0) {
			return 0;
		}

		int result = 0;

		for (int i = 0; i < 32; i++) {
			result <<= 1;
			result += n & 1;
			n >>>= 1;			
		}
		return result;
	}

}
