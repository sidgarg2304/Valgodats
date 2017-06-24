package com.vishal.interviews.programcreek.bitmanipulation;

public class SingleNumber {

	public static void main(String[] args) {

	}

	int findMissing(int[] nums) {
		int x = 0;
		for (int i : nums) {
			x ^= i;
		}

		return x;
	}

}
