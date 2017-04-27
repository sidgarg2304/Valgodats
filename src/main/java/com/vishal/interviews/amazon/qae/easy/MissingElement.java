package com.vishal.interviews.amazon.qae.easy;

import java.util.Arrays;

/**
 * Find the missing element from the given 2 array, second array is duplicate.
 * array 1: [1,2,3,4,5,6,7] array2: [1,3,4,5,6,7]
 *
 */
public class MissingElement {

	public static void main(String[] args) {

		System.out.println(missingElement(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 1, 3, 4, 5, 6, 7 }));
		System.out.println(missingElement(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 1, 2, 3, 4, 5, 6 }));
		System.out.println(missingElement(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
	}

	static int missingElement(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0;
		int j = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				return nums1[i];
			} else {
				return nums2[j];
			}
		}

		// i stopped before reaching last position
		if (i < nums1.length) {
			return nums1[i];
		}

		// j stopped before reaching last position
		if (j < nums2.length) {
			return nums2[j];
		}
		return -1;
	}

}
