package com.vishal.interviews.top100linkedquestions.easy;

public class HouseRobber {

	public static void main(String[] args) {

	}

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int f = nums[0];
		int s = nums[1];		
		for (int i = 2; i < nums.length; i++) {
			int cur = Math.max(f, s + nums[i]);			
			f = s;
			s = cur;
		}
		return Math.max(f, s);
	}

}
