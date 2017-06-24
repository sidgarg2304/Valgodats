package com.vishal.interviews.leetcodereremaining;

import java.util.*;
/**
 * 624. Maximum Distance in Arrays
 * 
 * Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

Example 1:
Input: 
[[1,2,3],
 [4,5],
 [1,2,3]]
Output: 4
Explanation: 
One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 *
 */
public class MaximumDistanceinArrays {

	public static void main(String[] args) {

	}

	public int maxDistance(List<List<Integer>> arrays) {

		if (arrays == null || arrays.size() == 0) {
			return 0;
		}

		int res = Integer.MIN_VALUE;
		int min = arrays.get(0).get(0);
		int max = arrays.get(0).get(arrays.get(0).size() - 1);

		for (int i = 1; i < arrays.size(); i++) {
			List<Integer> cur = arrays.get(i);

			res = Math.max(res, Math.abs(cur.get(0) - max));
			res = Math.max(res, Math.abs(cur.get(cur.size() - 1) - min));

			max = cur.get(cur.size() - 1);
			min = cur.get(0);

		}

		return res;
	}

}
