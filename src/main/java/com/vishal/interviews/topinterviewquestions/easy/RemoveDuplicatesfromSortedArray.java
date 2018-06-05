package com.vishal.interviews.topinterviewquestions.easy;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {

	}

	public int removeDuplicates(int[] nums) {
		
		if(nums == null || nums.length == 0){
			return 0;
		}

		int r = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[r++] = nums[i];
			}
		}
		return r;
	}

}
