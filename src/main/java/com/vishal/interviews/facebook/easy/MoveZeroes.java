package com.vishal.interviews.facebook.easy;

/**
 * 283. Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * 1. You must do this in-place without making a copy of the array.
 * 2. Minimize the total number of operations.
 */
public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Simple O(N) Java Solution Using Insert Index
	 * Shift non-zero values as far forward as possible
	 * Fill remaining space with zeros
	 */

	public void moveZeroes(int[] nums) {
	    if (nums == null || nums.length == 0) return;        

	    int insertPos = 0;
	    for (int num: nums) {
	        if (num != 0) nums[insertPos++] = num;
	    }        

	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
	}
	
	/**
	 * 1ms Java solution
	 */
	
	public void moveZeroes2(int[] nums) {

	    int j = 0;
	    for(int i = 0; i < nums.length; i++) {
	        if(nums[i] != 0) {
	            int temp = nums[j];
	            nums[j] = nums[i];
	            nums[i] = temp;
	            j++;
	        }
	    }
	}

}
