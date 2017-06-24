package com.vishal.interviews.leetcodereremaining.medium;

public class OptimalDivision {

	public static void main(String[] args) {

	}

	public String optimalDivision(int[] nums) {
		StringBuilder sb = new StringBuilder();
		sb.append(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			if (i == 1 && nums.length > 2) {
				sb.append("/(").append(nums[i]);
			} else {
				sb.append("/").append(nums[i]);
			}
		}

		sb.append(nums.length > 2 ? ")" : "");
		
		return sb.toString();
	}

}
