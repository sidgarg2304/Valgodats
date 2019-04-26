package com.vishal.interviews.facebook.medium;

public class WiggleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void wiggleSort(int[] nums) {

		for (int i = 1; i < nums.length; i++) {
			if (i % 2 == 0) {
				if (nums[i] > nums[i - 1]) {
					swap(nums, i, i - 1);
				}
			} else {
				if (nums[i] < nums[i - 1]) {
					swap(nums, i, i - 1);
				}
			}
		}
	}

	void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
