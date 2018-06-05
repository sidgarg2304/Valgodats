package com.vishal.interviews.top100linkedquestions.easy;

public class SingleNumber {

	public static void main(String[] args) {

	}
	
	public int singleNumber(int[] nums) {
		
		int res = 0;
		for(int i: nums){
			res ^= i;
		}
		
		return res;
	}

}
