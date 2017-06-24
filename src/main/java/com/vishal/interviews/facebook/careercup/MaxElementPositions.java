package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * You have a array with integers:
 * 
 * 
 * [ 1, -2, 0, 6, 2, -4, 6, 6 ] You need to write a function which will evenly
 * return indexes of a max value in the array. In the example below max value is
 * 6, and its positions are 3, 6 and 7. So each run function should return
 * random index from the set.
 * 
 * Try to implement with O(n) for computation and memory. Try to reduce memory
 * complexity to O(1).
 *
 */
public class MaxElementPositions {

	public static void main(String[] args) {

		System.out.println(maxElementPositions(new int[] { 1, -2, 0, 6, 2, -4, 6, 6 }));
	}

	static List<Integer> maxElementPositions(int[] nums) {
		List<Integer> res = new ArrayList<>();

		int max = nums[0];
		res.add(0);

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				res.clear();
				res.add(i);
			} else if (nums[i] == max) {
				res.add(i);
			}
		}

		return res;
	}

}
