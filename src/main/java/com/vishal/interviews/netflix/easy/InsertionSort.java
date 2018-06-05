package com.vishal.interviews.netflix.easy;

public class InsertionSort {

	public static void main(String[] args) {

	}

	public void insertionSort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] < nums[j]) {
					swap(nums, i, j);
				}
			}
		}
	}

	void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}
