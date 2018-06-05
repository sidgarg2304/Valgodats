package com.vishal.interviews.top100linkedquestions.medium;

import java.util.Arrays;

public class SearchforaRange {

	public static void main(String[] args) {

	}

	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		Arrays.fill(res, -1);

		int i = 0;
		int j = nums.length - 1;
		while (i <= j) {
			int m = i + (j - i) / 2;
			if (nums[m] == target) {
				int st = m;

				while (st >= 0 && nums[st] == target) {
					st--;
				}
				res[0] = st + 1;

				int en = m;
				while (en < nums.length && nums[en] == target) {
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
