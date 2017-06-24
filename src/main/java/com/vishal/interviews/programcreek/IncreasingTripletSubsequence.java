package com.vishal.interviews.programcreek;

public class IncreasingTripletSubsequence {

	public static void main(String[] args) {

	}

	public boolean increasingTriplet(int[] nums) {
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int z = nums[i];
			if (z <= x) {
				x = z;
			} else if (z <= y) {
				y = z;
			} else {
				return true;
			}
		}
		return false;
	}

}
