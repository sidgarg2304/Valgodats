package com.vishal.interviews.uber.hard;

public class ReversePairs {

	public int reversePairs(int[] nums) {
		return mergeSort(nums, new int[nums.length], 0, nums.length - 1);
	}

	int mergeSort(int[] nums, int[] temp, int st, int en) {

		if (st >= en) {
			return 0;
		}

		int res = 0;

		int m = st + (en - st) / 2;
		res += mergeSort(nums, temp, st, m);
		res += mergeSort(nums, temp, m + 1, en);

		int i = 0;
		int j = m + 1;
		while (i <= m) {
			if (j <= en && nums[i] / 2.0 > nums[j]) {
				j++;
			}
			res += j - m - 1;
		}
		merge(nums, temp, st, m, en);

		return res;
	}

	void merge(int[] nums, int[] temp, int st, int m, int en) {
		for (int i = st; i <= en; i++) {
			temp[i] = nums[i];
		}

		int i = st;
		int j = m + 1;
		int k = st;
		while (i <= m && j <= en) {
			if (temp[i] < temp[j]) {
				nums[k++] = temp[i++];
			} else {
				nums[k++] = temp[j++];
			}
		}
		
		while(i <= m) {
			nums[k++] = temp[i++];
		}
	}
}
