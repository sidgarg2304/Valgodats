package com.vishal.interviews.topinterviewquestions.hard;

public class FirstMissingPositive {

	public static void main(String[] args) {

	}

	public int firstMissingPositive(int[] nums) {

		int i = 0;
		while (i < nums.length) {
			if (nums[i] <= 0 || nums[i] > nums.length || nums[i] == i + 1) {
				i++;
			} else if (nums[nums[i] - 1] != nums[i]) {
				swap(nums, i, nums[i] - 1);
			} else {
				i++;
			}
		}

		i = 0;
		while (i < nums.length) {
			if (nums[i] == i + 1) {
				i++;
			} else {
				break;
			}
		}
		return i + 1;
	}

	void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
