package com.vishal.interviews.programcreek.sorting;

import com.vishal.interviews.util.Interval;

public class MaximumGap {

	public static void main(String[] args) {

	}

	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		Interval[] intervals = new Interval[nums.length + 1];
		for (int i = 0; i < intervals.length; i++) {
			intervals[i] = new Interval(-1, -1);
		}

		int min = nums[0];
		int max = nums[0];
		for (int i : nums) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}

		double interval = (double) (nums.length) / (max - min);

		for (int i = 0; i < nums.length; i++) {
			int index = (int) ((nums[i] - min) * interval);
			Interval cur = intervals[index];
			if (cur.st == -1) {
				cur.st = nums[i];
				cur.en = nums[i];
			} else {
				cur.st = Math.min(cur.st, nums[i]);
				cur.en = Math.max(cur.en, nums[i]);
			}
		}

		int res = 0;
		int prev = intervals[0].en;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].st != -1) {
				res = Math.max(res, intervals[i].st - prev);
				prev = intervals[i].en;
			}
		}

		return res;
	}

}
