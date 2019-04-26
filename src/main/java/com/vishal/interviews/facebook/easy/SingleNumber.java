package com.vishal.interviews.facebook.easy;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int singleNumber(int[] nums) {
		int xor = 0;
		for(int i: nums){
			xor ^= i;
		}
		return xor;
	}

}
