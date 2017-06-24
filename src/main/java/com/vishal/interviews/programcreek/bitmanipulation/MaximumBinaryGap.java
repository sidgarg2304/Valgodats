package com.vishal.interviews.programcreek.bitmanipulation;

public class MaximumBinaryGap {

	public static void main(String[] args) {

	}

	public static int getGap(int n) {

		int max = 0;
		int count = -1;
		int r = 0;
		while (n > 0) {
			r = n & 1;
			n >>= 1;

			if (r == 0 && count >= 0) {
				count++;
			}

			if (r == 1) {
				max = Math.max(max, count);
				count = 0;
			}
		}

		return max;
	}

}
