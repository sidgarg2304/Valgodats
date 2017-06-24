package com.vishal.interviews.programcreek.bitmanipulation;

public class SingleNumberII {

	public static void main(String[] args) {

	}

	public int singleNumber(int[] nums) {
		int res = 0;

		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int j : nums) {
				sum += (j >> i) & 1;
			}
			sum %= 3;
			res |= sum << i;

		}
		return res;
	}

}
