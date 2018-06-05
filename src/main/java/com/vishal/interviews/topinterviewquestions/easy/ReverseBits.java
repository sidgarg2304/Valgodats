package com.vishal.interviews.topinterviewquestions.easy;

public class ReverseBits {

	public static void main(String[] args) {

	}

	public int reverseBits(int n) {

		int r = 0;
		for (int i = 0; i < 32; i++) {			
			r <<= 1;
			n >>= 1;
			r |= n & 1;			
		}
		return r;
	}

}
