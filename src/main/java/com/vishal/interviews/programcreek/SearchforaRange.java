package com.vishal.interviews.programcreek;

public class SearchforaRange {

	public static void main(String[] args) {

	}

	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];

		if (nums == null || nums.length == 0) {
			return res;
		}

		int i = 0;
		int j = nums.length - 1;
		while (i <= j) {
			int m = i + (j - i) / 2;
			if (target == nums[m]) {

				int l = m;
				while (l >= 0 && nums[l] == target) {
					l--;
				}

				int r = m;
				while (r < nums.length && nums[r] == target) {
					r++;
				}

				res[0] = l + 1;
				res[1] = r - 1;
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
