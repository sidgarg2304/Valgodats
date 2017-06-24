package com.vishal.interviews.programcreek.bitmanipulation;

public class CountingBits {

	public static void main(String[] args) {

	}

	/**
	 * right shift by 1 is divide by 2
	 * left shift by 1 is multiply by 2
	 * 
	 * We can get number of bits of current number by getting number of bits of previously caclucated smaller number
	 * which is right shift by 1 and add one if the last bit is 1
	 */
	public int[] countBits(int num) {
		int[] res = new int[num + 1];

		for (int i = 1; i <= num; i++) {
			res[i] = res[i >> 1] + (i & 1);
		}
		return res;
	}
}
