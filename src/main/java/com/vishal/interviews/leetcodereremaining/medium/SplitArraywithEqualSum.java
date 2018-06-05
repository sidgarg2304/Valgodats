package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

/**
 * 
 * 548. Split Array with Equal Sum
 * 
 * Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:

0 < i, i + 1 < j, j + 1 < k < n - 1
Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.
Example:
Input: [1,2,1,2,1,2,1]
Output: True
Explanation:
i = 1, j = 3, k = 5. 
sum(0, i - 1) = sum(0, 0) = 1
sum(i + 1, j - 1) = sum(2, 2) = 1
sum(j + 1, k - 1) = sum(4, 4) = 1
sum(k + 1, n - 1) = sum(6, 6) = 1
 *
 */
public class SplitArraywithEqualSum {

	public static void main(String[] args) {

	}

	public boolean splitArray(int[] nums) {
		if (nums == null || nums.length < 7) {
			return false;
		}
		int[] prefixSum = new int[nums.length];
		prefixSum[0] = nums[0];
		for (int i = 1; i < prefixSum.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i];
		}

		// j can start only at 3 and max can go up to length -4;
		for (int j = 3; j <= nums.length - 4; j++) {

			Set<Integer> set = new HashSet<>();
			// i can start at 1 and max can go up to j-2
			// i+1 = j-1 which comes to i = j-2
			// get combinations for (0, i - 1), (i + 1, j - 1)
			// 0 , i-1, <i> i+1, j-1 <j>
			for (int i = 1; i <= j - 2; i++) {
				if (prefixSum[i - 1] == prefixSum[j - 1] - prefixSum[i]) {
					set.add(prefixSum[i - 1]);
				}
			}

			// get combinations for (j + 1, k - 1) (k + 1, n - 1)
			for (int k = j + 2; k <= nums.length - 2; k++) {
				if (prefixSum[k - 1] - prefixSum[j] == prefixSum[prefixSum.length - 1] - prefixSum[k]
						&& set.contains(prefixSum[k - 1] - prefixSum[j])) {
					return true;
				}
			}
		}
		return false;
	}

}
