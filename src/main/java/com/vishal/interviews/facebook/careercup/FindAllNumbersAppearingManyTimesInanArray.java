package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * Given an array of n elements which contains elements from 0 to n-1, with any
 * of these numbers appearing any number of times. Find these repeating numbers
 * in O(n) and using only constant memory space. Try to do it in one pass
 * example [4, 2, 0, 5, 2, 0, 1] return: 0, 2 [1, 2, 3, 0, 0, 1, 3, 6, 6,6]
 * return 0, 1, 3, 6
 *
 */
public class FindAllNumbersAppearingManyTimesInanArray {

	public static void main(String[] args) {

		System.out.println(findRepeat(new int[] { 1, 2, 3, 0, 0, 1, 3, 6, 6, 6 }));
	}

	public static List<Integer> findRepeat(int nums[]) {
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			nums[i]++;
		}

		for (int i = 0; i < nums.length; i++) {
			int pos = Math.abs(nums[i]) - 1;
			if (nums[pos] < 0) {
				if (!res.contains(pos)) {
					res.add(pos);
				}
			} else {
				nums[pos] *= -1;
			}
		}
		return res;
	}

}
