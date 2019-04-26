package com.vishal.interviews.facebook.medium;

public class SingleNumberIII {

	public static void main(String[] args) {

	}
	
	public int[] singleNumber(int[] nums) {

		int diff = 0;
		for (int i : nums) {
			diff ^= i;
		}

		diff = diff & ~(diff - 1);

		int[] res = new int[2];
		for (int i : nums) {
			if ((i & diff) == 0) {
				res[0] ^= i;
			} else {
				res[1] ^= i;
			}
		}

		return res;
	}

}
