package com.vishal.interviews.programcreek.math;

public class PowerofTwo {

	public static void main(String[] args) {

	}
	
	public boolean isPowerOfTwo(int n) {
		return n > 0 && (n & n-1) == 0;
	}

}
