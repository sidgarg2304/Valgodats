package com.vishal.interviews.facebook.easy;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void rotate(int[] nums, int k) {

		if(nums == null || nums.length <= 1){
			return;
		}
		k %= nums.length;
		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}

	void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}

}
