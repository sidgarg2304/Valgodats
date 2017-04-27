package com.vishal.interviews.amazon.qae.easy;

/**
 * Write program for the following scenario Input Array :- {1,2,3,4,5,5,5,6,7,7}
 * Output:- 5 is repeated 3 times 7 is repeated 2 times
 *
 */
public class MaxRepeatedNumberInSortedArray {

	public static void main(String[] args) {

		System.out.println(maxRepeatedNumber(new int[] { 1, 2, 3, 4, 5, 5, 5, 6, 7, 7 }));
		System.out.println(maxRepeatedNumber(new int[] { 1, 2, 3, 4, 5, 5, 5, 6, 7, 7, 7, 7 }));
	}

	static int maxRepeatedNumber(int[] nums) {
		int prev = nums[0];
		int ct = 1;

		int res = nums[0];
		int maxCt = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				ct++;
			} else {
				if (ct > maxCt) {
					res = prev;
					maxCt = ct;
				}

				prev = nums[i];
				ct = 1;

			}
		}
		
		if (ct > maxCt) {
			res = prev;			
		}

		return res;
	}

}
