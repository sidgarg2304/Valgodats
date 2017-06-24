package com.vishal.interviews.programcreek.bitmanipulation;

public class Numberof1Bits {

	public static void main(String[] args) {

	}

	public int hammingWeight(int n) {
		int res = 0;
		while (n > 0) {
			res += n & 1;
			n >>= 1;
		}

		return res;
	}

}
