package com.vishal.interviews.facebook.medium;

public class SortTransformedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {

		if (nums == null || nums.length == 0) {
			return new int[] {};
		}

		int[] res = new int[nums.length];

		int i = 0;
		int j = nums.length - 1;
		int k = a < 0 ? 0 : nums.length - 1;

		while (i <= j) {
			if (a < 0) {
				res[k++] = compute(nums[i], a, b, c) < compute(nums[j], a, b, c) ? compute(nums[i++], a, b, c)
						: compute(nums[j--], a, b, c);
			} else {
				res[k--] = compute(nums[i], a, b, c) < compute(nums[j], a, b, c) ? compute(nums[j--], a, b, c)
						: compute(nums[i++], a, b, c);
			}
		}

		return res;
	}

	int compute(int x, int a, int b, int c) {
		return (a * x * x) + (b * x) + c;
	}

}
