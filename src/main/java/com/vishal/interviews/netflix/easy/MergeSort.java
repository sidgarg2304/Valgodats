package com.vishal.interviews.netflix.easy;

public class MergeSort {

	public static void main(String[] args) {

	}

	void mergeSort(int[] nums) {
		int[] t = new int[nums.length];
		mergeSort(nums, t, 0, nums.length - 1);
	}

	void mergeSort(int[] nums, int[] t, int st, int en) {

		if (st <= en) {
			int m = st + (en - st) / 2;
			mergeSort(nums, t, st, m);
			mergeSort(nums, t, m + 1, en);
			merge(nums, t, st, m, en);
		}
	}

	void merge(int[] nums, int[] t, int st, int m, int en) {
		for (int i = st; i <= en; i++) {
			t[i] = nums[i];
		}

		int i = st;
		int j = m + 1;
		int k = st;

		while (i <= m && j <= en) {
			if (t[i] < t[j]) {
				nums[k++] = t[i++];
			} else {
				nums[k++] = t[j++];
			}
		}

		for (int r = i; r <= m; r++) {
			nums[k++] = t[r];
		}
	}

}
