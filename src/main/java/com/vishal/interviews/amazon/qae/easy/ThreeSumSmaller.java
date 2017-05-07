package com.vishal.interviews.amazon.qae.easy;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
 */
public class ThreeSumSmaller {

	public static void main(String[] args) {

	}

	public int threeSumSmaller(int[] nums, int target) {
		int res = 0;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < target) {
					/**
					 * Because if we add any element less than k to element at i and
					 * element at j, the sum will be less than target, So for for i
					 * and j positions, there will be k-j combinations. We can start
					 * with increasing i to try new combinations.
					 * 
					 * Eg: {1 4 7 9}, target = 18
					 * i == 1, j == 4 and k = 9, the combinations are {1,4,9}, {1,4,7}  
					 * Next, we can start with i = 1 and j = 7 and the combinations are {1,7,9}
					 */
					res += k - j;
					j++;
				} else {
					k--;
				}
			}
		}
		return res;
	}

}
