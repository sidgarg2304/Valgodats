package com.vishal.interviews.facebook.easy;

public class Numberof1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int hammingWeight(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res += n & 1;
			n >>= 1;
		}
		return res;
		
	}

}
