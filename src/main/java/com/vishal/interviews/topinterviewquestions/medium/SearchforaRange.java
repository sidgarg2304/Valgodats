package com.vishal.interviews.topinterviewquestions.medium;

public class SearchforaRange {

	public static void main(String[] args) {

	}

	public int[] searchRange(int[] nums, int target) {
		int i = 0;
		int j = nums.length - 1;

		int[] res = new int[2];
		while (i <= j) {
			int m = i + (j - i) / 2;
			if (nums[m] == target) {
				int st = i;
				while (nums[st] == target) {
					st--;
				}
				res[0] = st + 1;

				int en = i;
				while (nums[en] == target) {
					en++;
				}
				res[1] = en - 1;
				break;
			} else if (target < nums[m]) {
				j = m - 1;
			} else {
				i = m + 1;
			}
		}
		return res;
	}
}
