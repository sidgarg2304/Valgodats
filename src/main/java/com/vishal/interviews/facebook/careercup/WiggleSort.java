package com.vishal.interviews.facebook.careercup;

/**
 * Gives an array of unsorted int (may have negative number), 
rearrange the array such that the 
num at the odd index is greater than the num at the even index. 
example 
giving 5, 2, 3, 4, 1, one of the expected result is 1,4,2,5,3, 
please solve it in o(n) time, where n is the length of the array 
 *
 */
public class WiggleSort {

	public static void main(String[] args) {

	}

	public void rearrange(int[] nums) {

		for (int i = 1; i < nums.length; i++) {
			if (i % 2 == 0) {
				if(nums[i] > nums[i-1]){
					swap(nums,i, i-1);
				}
			} else {
				if(nums[i] < nums[i-1]){
					swap(nums,i, i-1);
				}
			}
		}
	}
	
	void swap(int[] nums, int i, int j){
		
	}

}
