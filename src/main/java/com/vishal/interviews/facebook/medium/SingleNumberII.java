package com.vishal.interviews.facebook.medium;

public class SingleNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int singleNumber(int[] nums) {

		int res = 0;

		for (int i = 0; i < 32; i++) {

			int sum = 0;
			for(int num : nums){
				sum += (num >> i) & 1;
			}
			sum %= 3;
			res |= sum << i;
			
		}
		return res;
	}

}
