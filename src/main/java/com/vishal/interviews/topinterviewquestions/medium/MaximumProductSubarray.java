package com.vishal.interviews.topinterviewquestions.medium;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProduct(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int res = nums[0];

		int curMax = nums[0];
		int curMin = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int temp = curMax;

			curMax = Math.max(Math.max(nums[i], nums[i] * curMax), nums[i] * curMin);
			curMin = Math.min(Math.min(nums[i], nums[i] * temp), nums[i] * curMin);

			res = Math.max(curMax, res);
		}

		return res;
	}

}
