package com.vishal.interviews.amazon.qae.easy;

import java.util.Arrays;

/**
 * Find the first and last occurrence of a number in a sorted array of integers
 * For Example: int[] a = {1,2,3,4,5,5,7,8}
 *
 */
public class FindFirstAndSecondOccurence {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(findFirstAndSecondOccurence(new int[] { 1, 2, 3, 4, 5, 5, 7, 8 }, 5)));
	}

	static int[] findFirstAndSecondOccurence(int[] nums, int target) {

		int[] res = new int[2];
		int i = 0;
		int j = nums.length - 1;

		while (i <= j) {

			int m = (i + j) / 2;
			
			if (nums[m] == target) {
				
				int st = m;
				while (nums[st] == target) {					
					st--;
				}
				res[0] = st + 1;

				int en = m;
				while (nums[en] == target) {
					System.out.println("v1");
					en++;
				}
				res[1] = en - 1;
				
				break;
				
			} else if (target < nums[m]) {
				j = m - 1;
			} else {
				i = m + 1;
			}
		}

		return res;
	}

}
