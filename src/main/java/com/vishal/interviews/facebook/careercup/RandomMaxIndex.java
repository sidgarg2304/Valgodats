package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * e.g. Given [11,30,2,30,30,30,6,2,62, 62]
 * 
 * Having iterated up to the at element index 5 (where the last 30 is), randomly
 * give an index among [1, 3, 4, 5] which are indices of 30 - the max value by
 * far. Each index should have a ¼ chance to get picked.
 * 
 * Having iterated through the entire array, randomly give an index between 8
 * and 9 which are indices of the max value 62.
 *
 */
public class RandomMaxIndex {

	public static void main(String[] args) {

		System.out.println(randMaxIndex(new int[] { 11, 30, 2, 30, 30, 30, 6, 2, 62, 62 }));
	}

	static int randMaxIndex(int[] nums) {
		Random rand = new Random();

		List<Integer> maxIndexes = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				maxIndexes.clear();
				maxIndexes.add(i);
			} else if (nums[i] == max) {
				maxIndexes.add(i);
			}
		}

		return maxIndexes.get(rand.nextInt(maxIndexes.size()));
	}

}
