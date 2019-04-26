package com.vishal.interviews.topinterviewquestions.hard;

public class FirstMissingPositive {

	public static void main(String[] args) {

	}
	
	public int firstMissingPositiveEasySol(int[] nums) {

		boolean contains1 = false;
		for (int i : nums) {
			if (i == 1) {
				contains1 = true;
				break;
			}
		}

		if (!contains1) {
			return 1;
		}

		if (nums.length == 1) {
			return 2;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0 || nums[i] > nums.length) {
				nums[i] = 1;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			int pos = Math.abs(nums[i]) - 1;
			nums[pos] = -Math.abs(nums[pos]);
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				return i + 1;
			}
		}

		return nums.length + 1;
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
