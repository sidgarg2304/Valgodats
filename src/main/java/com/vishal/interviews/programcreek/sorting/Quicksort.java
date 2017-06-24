package com.vishal.interviews.programcreek.sorting;

public class Quicksort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void quickSort(int[] nums) {

		quickSort(nums, 0, nums.length - 1);
	}

	static void quickSort(int[] nums, int st, int en) {
		if (st > en) {
			return;
		}

		int p = partition(nums, st, en);

		quickSort(nums, st, p - 1);
		quickSort(nums, p + 1, en);

	}

	static int partition(int[] nums, int st, int en) {
		int p = st;

		int pivot = nums[en];

		for (int i = st; i < en; i++) {
			if (nums[i] < pivot) {
				swap(nums, i, p++);
			}
		}

		swap(nums, p, en);

		return p;
	}

	static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
