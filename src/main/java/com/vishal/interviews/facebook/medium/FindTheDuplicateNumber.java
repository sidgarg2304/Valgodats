package com.vishal.interviews.facebook.medium;

public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findDuplicate(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			int p = Math.abs(nums[i]) - 1;
			if (nums[p] < 0) {
				return p + 1;
			}
			nums[p] = -nums[p];
		}
		return -1;  
		
	}

}
