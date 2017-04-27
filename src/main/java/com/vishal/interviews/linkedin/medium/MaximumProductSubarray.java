package com.vishal.interviews.linkedin.medium;

/**
 * 152. Maximum Product Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {

	public static void main(String[] args) {

	}
	
	static int maxprodSubArray(int[] nums){
		
		int maxHerePre = nums[0];
		int minHerePre = nums[0];
		
		int maxSofar = nums[0];
		
		for(int i = 1; i< nums.length;i++){
			int maxHere = Math.max(maxHerePre * nums[i], minHerePre * nums[i]);
			maxHere = Math.max(maxHere, nums[i]);
			
			int minHere = Math.min(maxHerePre * nums[i], minHerePre * nums[i]);
			minHere = Math.min(minHere, nums[i]);
			maxSofar = Math.max(maxSofar, maxHere);
			
			maxHerePre = maxHere;
			minHerePre = minHere;
			
		}
		
		return maxSofar;
	}

}
