package com.vishal.interviews.programcreek.math;

public class PowerofFour {

	public static void main(String[] args) {

	}

	public boolean isPowerOfFour(int num) {
		int count1 = 0;
		int count0 = 0;

		while (num > 0) {
			if ((num & 1) == 1) {
				count1++;
			} else {
				count0++;
			}
			num >>= 1;
		}
		
		return count1 == 1 && count0 % 2 == 0;
	}

}
