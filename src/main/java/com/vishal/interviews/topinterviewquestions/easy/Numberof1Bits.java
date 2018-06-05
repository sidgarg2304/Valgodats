package com.vishal.interviews.topinterviewquestions.easy;

public class Numberof1Bits {

	public static void main(String[] args) {

	}

	public int hammingWeight(int n) {

		int res = 0;
		for (int i = 1; i <= 32; i++) {
			res += n & 1;
			n >>= 1;
		}
		return res;
	}

}
